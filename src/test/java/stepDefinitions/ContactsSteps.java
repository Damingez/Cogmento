package stepDefinitions;

import cucumberOptions.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsSteps extends TestBase {

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
        Assert.assertTrue("Page is not displayed", isContactIconDisplayed);
    }

    @When("^Contacts page is displayed$")
    public void the_user_is_on_contacts_page() {
        boolean isContactPageDisplayed = driver.findElement(By.xpath("//div[ contains(text(),'Contacts')]")).isDisplayed();
        Assert.assertTrue("Page is not displayed", isContactPageDisplayed);
    }

    @When("^the user clicks on trash icon of contact: \"([^\"]*)\"$")
    public void the_user_clicks_on_trash_icon(String fullname) {
        WebElement row = driver.findElement(By.xpath("//tr[. = '" + fullname + "']"));
        row.findElement(By.xpath("//i[@class='trash icon']")).click();
    }

    @When("^the user clicks on the delete button$")
    public void the_user_clicks_on_the_delete_button() {
        WebDriverWait buttonWait = new WebDriverWait(driver, 4);
        buttonWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ui button']"))).click();
     //   buttonWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui tiny modal transition visible active']")));
    }

    @Then("^number of the contacts equals to: \"([^\"]*)\"$")
    public void number_of_the_contacts_is_equal_to(int number) {
//        WebDriverWait waitForElements = new WebDriverWait(driver, 5);
//        waitForElements.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody/tr")));
        int numberOfElements = driver.findElements(By.xpath("//input[@class='hidden']")).size();
        Assert.assertEquals(number, numberOfElements);
    }

    @Then("^Contact with name: \"([^\"]*)\" exists$")
    public void the_contact_with_name_something_exists(String fullname) {
        WebDriverWait waitForRow = new WebDriverWait(driver, 3);
        WebElement contactRow = waitForRow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[. = '" + fullname + "']")));
        boolean isPresent = contactRow.isDisplayed();
        Assert.assertTrue("Employee does't exist", isPresent);
    }
}
