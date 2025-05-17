package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
// import pages.BasePages;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources", 
    glue = "steps",                
    plugin = {
        "pretty",
        "html:reports.cucumber",             
        "json:target/cucumber.json"           
    },
    monochrome = true
)

public class Runner {

    @AfterClass
    public static void cleanDriver() {
        // BasePages.cerrarNavegador();
    }
}
