package stepDefinitions;

import cucumberOptions.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks extends TestBase {

    public WebDriver driver;

    @Before("@SmokeTest")
    public void beforeTest() {
        driver = getDriver();
    }


    @After("@SmokeTest")
    public void afterTest() {
        driver.quit();
    }

}
