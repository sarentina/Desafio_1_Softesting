package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePages {

    protected static WebDriver driver;
    // private static Actions action;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
    }

    public BasePages(WebDriver driver) {
        BasePages.driver = driver;
    }

    public void navegateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.close();
    }

    // Metodo para hallar un elemento por su selector XPath
    private WebElement encontrarElementoXpath(String localizador) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(localizador)));

    }

    // Metodo para hallar un elemento por su selctor Id
    private WebElement encontrarElementoId(String localizador) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(localizador)));
    }

    //Metodo para encontrar un elemento por su nombre
    public WebElement encontrarElementoName(String localizador){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.name(localizador)));
    }


    //  Clicar algun elemento con selector Id
    public void clicarElementoId(String localizador){
        encontrarElementoId(localizador).click();
    }

    // Clicar algun elemento con selector XPath
    public void clicarElementoXpath(String localizador){
        encontrarElementoXpath(localizador).click();
    }

    // Escribe en un campo de texto
    public void escribirCampo(String localizador, String busqueda){
        encontrarElementoName(localizador).clear();
        encontrarElementoName(localizador).sendKeys(busqueda);
    }

    // Metodo para ir a la pagina de amazon por su XPath
    public void clicarPagina(String locator){
        encontrarElementoXpath(locator).click();;
    }
}
