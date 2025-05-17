package pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearchPages extends BasePages {

    private final String searchBoxName = "field-keywords";
    private final String searchButtonId = "nav-search-submit-button";
    private final String secondPageXPath = "//a[@aria-label='Ir a la página 2']";
    private final By captchaInput = By.id("captchacharacters");
    private final By agregarAlCarritoBtn = By.id("add-to-cart-button");
    By cantidadSelect = By.cssSelector("select.a-native-dropdown.a-declarative");

    public AmazonSearchPages() {
        super(driver);
    }

    public void navegarA() {
        navegateTo("https://www.amazon.com/");
        esperarQueSeResuelvaCaptcha();
    }

    public void esperarCarga() {
        esperarElementoPorNombre(searchBoxName, 15);
    }

    public void buscarProducto(String producto) {
        escribirCampo(searchBoxName, producto);
        clicarElementoId(searchButtonId);
    }

    public void navegarASegundaPagina() {
        clicarPagina(secondPageXPath);
    }

    public void seleccionarProductoValidandoCarrito(int startPosition) {
        int posicion = startPosition;

        while (true) {
            try {
                // Volver a la lista de resultados si no estamos en ella
                driver.navigate().back();

                // Esperar que cargue lista de productos en la posición actual
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(getProductXPathByPosition(posicion))));

                // Clic en el producto actual usando tu método base
                clicarElementoXpath(getProductXPathByPosition(posicion));

                // Esperar y validar si está el botón de "Agregar al carrito"
                wait.until(ExpectedConditions.presenceOfElementLocated(agregarAlCarritoBtn));

                WebElement botonAgregar = driver.findElement(agregarAlCarritoBtn);
                if (botonAgregar.isDisplayed()) {
                    System.out.println("Botón 'Agregar al carrito' encontrado en el producto de posición: " + posicion);
                    break;
                }

            } catch (Exception e) {
                System.out.println("No se encontró el botón 'Agregar al carrito' en la posición: " + posicion);
                posicion++; // Intentar con el siguiente producto
            }
        }
    }

    // XPath dinámico para seleccionar productos según la posición
    private String getProductXPathByPosition(int position) {
        return String.format(
                "//div[contains(@data-component-type, 's-search-result')][%d]//a[contains(@class, 'a-link-normal') and contains(@class, 'a-text-normal')]",
                position);
    }

    public void esperarQueSeResuelvaCaptcha() {
        By captchaInput = By.id("captchacharacters");

        if (isCaptchaPresent()) {
            System.out.println("CAPTCHA detectado. Por favor resuélvelo manualmente...");

            // Usa tu wait para esperar que el captcha desaparezca
            wait.withTimeout(Duration.ofMinutes(5))
                    .until(ExpectedConditions.invisibilityOfElementLocated(captchaInput));

            System.out.println("CAPTCHA resuelto, continuando...");
        } else {
            System.out.println("No hay CAPTCHA, continúo normalmente.");
        }
    }

    public boolean isCaptchaPresent() {
        try {
            return driver.findElement(captchaInput).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void agregarAlCarrito() {
        try {
            WebElement botonAgregarCarrito = encontrarElementoId("add-to-cart-button"); // Reutilizando método de
                                                                                        // BasePages
            botonAgregarCarrito.click();
            System.out.println("Producto agregado al carrito exitosamente.");
        } catch (Exception e) {
            System.out.println("No se pudo agregar el producto al carrito: " + e.getMessage());
        }
    }

    public void seleccionarCategoria(String categoria) {
        Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
        select.selectByValue("search-alias=" + categoria);
    }
    

}
