package parallel;

import Common.Web_Common;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class BrowserSetup {

     static protected WebDriver driver;

    @Before
    public void setup(Scenario scenario) throws ParseException, IOException {
        Web_Common web_common = new Web_Common();
        System.out.println("Scenario name "+ scenario.getName());
        System.out.println("Test Before hook executed");
    }

    @After
    public void closeTest(){
        driver.quit();
        System.out.println("After test : Quit the Tests");
    }
}
