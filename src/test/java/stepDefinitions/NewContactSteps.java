package stepDefinitions;

import cucumberOptions.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewContactSteps extends TestBase {

    @When("^the user clicks on New button$")
    public void the_user_clicks_on_new_button() {
        WebDriverWait buttonWait = new WebDriverWait(driver, 3);
        buttonWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'New')]"))).click();
    }

    @When("^the user provides the Firstname \"([^\"]*)\" of the contact$")
    public void the_user_provides_the_firstname_of_the_contact(String firstName) {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
    }

    @When("^the user provides the LastName \"([^\"]*)\" of the contact$")
    public void the_user_provides_the_lastname_of_the_contact(String lastname) {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastname);
    }

    @When("^the user clicks on save button$")
    public void the_user_clicks_on_save_button() {
        driver.findElement(By.xpath("//*[contains(text(),'Save')]")).click();
    }

    @Then("^contact page is displayed$")
    public void contact_page_is_displayed() {
        WebDriverWait contactIcon = new WebDriverWait(driver, 3);
        boolean isContactIconDisplayed = contactIcon.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='large user red icon']"))).isDisplayed();
        Assert.assertTrue(isContactIconDisplayed);
    }
}
