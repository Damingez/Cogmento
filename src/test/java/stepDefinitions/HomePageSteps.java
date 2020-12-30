package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.kowalix.TestBase;
import pageObjects.HomePage;

public class HomePageSteps extends TestBase {

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() {
        Assert.assertTrue("There are no elements", getHomePage().isTableWithRowsPresent());
    }

    @When("^the user Fullname \"([^\"]*)\" is displayed in the upper panel$")
    public void user_full_name_is_displeyed_in_the_upper_panel(String fullName) {
        String text = getHomePage().getFullnameFromUpperPanel();
        Assert.assertTrue("Fullname is not present", text.contains(fullName));
    }


}
