package org.kowalix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public  class TestBase {

    public static WebDriver driver;
    public static Properties properties;

    public WebDriver getDriver()   {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dako\\Documents\\driver_for_practise\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver;
    }

    public static void init() throws IOException {
        properties = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\dako\\Desktop\\testing_projects\\Cogmento\\src\\test\\java\\org\\kowalix\\global.properties");
        properties.load(file);
    }


}
