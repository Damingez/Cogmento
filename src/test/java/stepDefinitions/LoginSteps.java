package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.kowalix.Base;
import pageObjects.LoginPage;

public class LoginSteps extends Base {

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    @Given("^the user is on Cogmento login page$")
    public void user_is_on_cogmento_landing_page() {
        LoginPage loginPage = getLoginPage();
     //   driver.navigate().to(prop.getProperty("url"));
        Assert.assertTrue("Login button is not present", loginPage.isLoginButtonPresent());
    }

    @When("^the user logins into application with \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application_with_something_and_password_something(String login, String password) {
        LoginPage loginPage = getLoginPage();
        loginPage.provideEmail(login);
        loginPage.providePassword(password);
        loginPage.clickLoginButton();
    }


}
