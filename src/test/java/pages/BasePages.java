package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

    public BasePages(WebDriver driver){
        BasePages.driver = driver;
    }

    public void navegateTo(String url){
        driver.get( url);
    }
    public static void closeBrowser(){
        driver.close();
    }


} 


