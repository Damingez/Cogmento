package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginStepDefinitions {

    public WebDriver driver;

    @Given("^User is on Cogmento landing page$")
    public void user_is_on_cogmento_landing_page() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dako\\Documents\\driver_for_practise\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://ui.freecrm.com/");
        boolean result = driver.findElement(By.xpath("//div[contains(text(),'Login')]")).isDisplayed();
        Assert.assertTrue(result);
    }

    @When("^User login into application with \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application_with_something_and_password_something(String login, String password) throws Throwable {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(login);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        WebDriverWait expliciteWait1 = new WebDriverWait(driver,4);
        expliciteWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='three column row']")));
        int numberOfElements = driver.findElements(By.xpath("//div[@class='three column row']")).size();
        Assert.assertTrue("There are no elements", numberOfElements > 0);
    }

    @When("^User Fullname \"([^\"]*)\" is displeyed in the upper panel$")
    public void user_full_name_is_displeyed_in_the_upper_panel(String fullname) throws Throwable {
        WebDriverWait expliciteWait1 = new WebDriverWait(driver, 4);
        expliciteWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='user-display']")));
        String text = driver.findElement(By.xpath("//span[@class='user-display']")).getText();
        Assert.assertTrue(text.contains(fullname));
        driver.quit();
    }

}
