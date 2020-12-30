package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//div[@class='three column row']")
    private WebElement tableWithRows;
    @FindBy(xpath = "//span[@class='user-display']")
    private WebElement fullNameLabel;

    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isTableWithRowsPresent() {
        return tableWithRows.isDisplayed();
    }

    public String getFullnameFromUpperPanel() {
        return fullNameLabel.getText();
    }
}
