package stepDefinitions;

import io.cucumber.java.en.Given;
import org.kowalix.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;

public class LoginSteps extends TestBase {

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    @Given("^the user is on Cogmento login page$")
    public void user_is_on_cogmento_landing_page() {
        driver.navigate().to(properties.getProperty("url"));
        boolean result = getLoginPage().isLoginButtonPresent();
        Assert.assertTrue("Login button is not present", result);
    }

    @When("^the user logins into application with \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application_with_something_and_password_something(String login, String password) {
        getLoginPage().provideEmail(login);
        getLoginPage().providePassword(password);
        getLoginPage().clickLoginButton();
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() {
        WebDriverWait expliciteWait1 = new WebDriverWait(driver, 4);
        expliciteWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='three column row']")));
        int numberOfElements = driver.findElements(By.xpath("//div[@class='three column row']")).size();
        Assert.assertTrue("There are no elements", numberOfElements > 0);
    }

    @When("^the user Fullname \"([^\"]*)\" is displeyed in the upper panel$")
    public void user_full_name_is_displeyed_in_the_upper_panel(String fullname) {
        WebDriverWait expliciteWait1 = new WebDriverWait(driver, 4);
        expliciteWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='user-display']")));
        String text = driver.findElement(By.xpath("//span[@class='user-display']")).getText();
        Assert.assertTrue(text.contains(fullname));
    }

}
