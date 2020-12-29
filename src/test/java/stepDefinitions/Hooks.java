package stepDefinitions;

import org.kowalix.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks extends TestBase {

    public WebDriver driver;

    @Before
    public void beforeTest() throws IOException {
        init();
        driver = getDriver();
    }


    @After
    public void afterTest() {
        driver.quit();
    }

}
