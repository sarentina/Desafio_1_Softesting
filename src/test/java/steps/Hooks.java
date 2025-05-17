package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.AmazonSearchPages;
import pages.BasePages;

public class Hooks {
    private static boolean isInitialized = false;
    private AmazonSearchPages amazonPage = new AmazonSearchPages();

    @Before(order = 0) // Se ejecuta antes que los steps
    public void setUp() {
        if (!isInitialized) {
            amazonPage.navegarA();
            isInitialized = true;
        }
    }

    
}