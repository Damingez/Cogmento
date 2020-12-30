package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.kowalix.TestBase;
import pageObjects.LoginPage;

public class LoginSteps extends TestBase {

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    @Given("^the user is on Cogmento login page$")
    public void user_is_on_cogmento_landing_page() {
        driver.navigate().to(properties.getProperty("url"));
        driver.manage().window().maximize();
        boolean result = getLoginPage().isLoginButtonPresent();
        Assert.assertTrue("Login button is not present", result);
    }

    @When("^the user logins into application with \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application_with_something_and_password_something(String login, String password) {
        getLoginPage().provideEmail(login);
        getLoginPage().providePassword(password);
        getLoginPage().clickLoginButton();
    }


}
