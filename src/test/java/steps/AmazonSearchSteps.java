package steps;

import io.cucumber.java.en.*;
import pages.AmazonSearchPages;

public class AmazonSearchSteps {
    private AmazonSearchPages Amazonpage = new AmazonSearchPages();

   @Given ("^The user navegates to https://www.amazon.com/$")
    public void navegateToAmazon(){
        Amazonpage.navegateTo();
        Amazonpage.espera();
    }

}
