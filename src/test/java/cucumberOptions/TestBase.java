package cucumberOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public  class TestBase {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dako\\Documents\\driver_for_practise\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }


}
