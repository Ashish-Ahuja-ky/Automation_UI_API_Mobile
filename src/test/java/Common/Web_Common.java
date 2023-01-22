package Common;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import parallel.BrowserSetup;

import java.io.FileReader;
import java.io.IOException;

public class Web_Common extends BrowserSetup{

    String browser;
    String url;

    public Web_Common() throws ParseException, IOException {
        readProjectData();
        openBrowser();
    }

    private void readProjectData() throws ParseException, IOException {
        JSONParser jsonParser = new JSONParser();
        JSONObject projectData = (JSONObject) jsonParser.parse(new FileReader("src/test/java/projectdata.json"));
        browser= String.valueOf(projectData.get("browser"));
        url = String.valueOf(projectData.get("url"));
    }

    /*

    start-maximized: Opens Chrome in maximize mode
    incognito: Opens Chrome in incognito mode
    headless: Opens Chrome in headless mode
    disable-extensions: Disables existing extensions on Chrome browser
    disable-popup-blocking: Disables pop-ups displayed on Chrome browser
    make-default-browser: Makes Chrome default browser
    version: Prints chrome browser version
    disable-infobars: Prevents Chrome from displaying the notification ‘Chrome is being controlled by automated software

     */
    public void openBrowser(){

        if(browser.equals(enums.CHROME.toString())){

            System.setProperty("webdriver.chrome.driver","driver/chromedriver");

            ChromeOptions chromeOptions = new ChromeOptions();

            chromeOptions.addArguments("start-maximized");
            chromeOptions.addArguments("disable-extensions");
            chromeOptions.addArguments("disable-popup-blocking");
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-gpu");
//            Remove below comment to run in incognito
//            chromeOptions.addArguments("--incognito");

            driver = new ChromeDriver(chromeOptions);
            driver.get(url);

        } else {
            System.out.println("WIP");
        }
    }

}

