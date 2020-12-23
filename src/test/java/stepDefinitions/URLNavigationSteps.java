package stepDefinitions;

import org.kowalix.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class URLNavigationSteps extends TestBase {

    @When("^the user uses URL to navigate to Contacts page$")
    public void user_uses_url_to_navigate_to_contacts_page()  {
        driver.navigate().to("https://ui.freecrm.com/contacts");
    }

    @Given("^the user is on Cogmento login page$")
    public void user_is_on_cogmento_landing_page() {
        driver.navigate().to(properties.getProperty("url"));
    //    driver.get(properties.getProperty("url"));
        boolean result = driver.findElement(By.xpath("//div[contains(text(),'Login')]")).isDisplayed();
        Assert.assertTrue(result);
    }

}
