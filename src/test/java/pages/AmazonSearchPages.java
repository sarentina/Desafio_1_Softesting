package pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearchPages extends BasePages {

    // Selectores claros y nombrados en camelCase
    private final String searchBoxName = "field-keywords"; // Por name
    private final String searchButtonId = "nav-search-submit-button"; // Por ID
    private final String secondPageXPath = "//a[@aria-label='Ir a la página 2']"; // XPath
    private final String thirdProductXPath = "//div[contains(@data-component-type, 's-search-result')][3]//a[contains(@class, 'a-link-normal') and contains(@class, 'a-text-normal')]"; // Mejora sobre tu XPath absoluto
    By captchaInput = By.id("captchacharacters");

    public AmazonSearchPages() {
        super(driver);
    }

    // Navegar a Amazon
    public void navegarA() {
        navegateTo("https://www.amazon.com/");
        esperarQueSeResuelvaCaptcha();
    }

    // Espera explícita opcional (mejor que Thread.sleep)
    public void esperarCarga() {
        esperarElementoPorNombre(searchBoxName, 15);
    }

    // Buscar producto en la barra de búsqueda
    public void buscarProducto(String producto) {
        escribirCampo(searchBoxName, producto);
        clicarElementoId(searchButtonId);
    }

    // Navegar a la segunda página de resultados
    public void navegarASegundaPagina() {
        clicarPagina(secondPageXPath);
    }

    // Seleccionar el tercer producto de la lista
    public void seleccionarTercerProducto() {
        clicarElementoXpath(thirdProductXPath);
    }

    public void esperarQueSeResuelvaCaptcha() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
        By captchaInput = By.id("captchacharacters");
    
        if (isCaptchaPresent()) {
            System.out.println("CAPTCHA detectado. Por favor resuélvelo manualmente...");
    
            // Espera hasta que el captcha ya no sea visible
            wait.until(ExpectedConditions.invisibilityOfElementLocated(captchaInput));
    
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
    

}

