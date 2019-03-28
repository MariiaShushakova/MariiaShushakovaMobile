package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactManager {
    private AppiumDriver driver;
    private By addButton = By.id("com.example.android.contactmanager:id/addContactButton");

    public ContactManager(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
    }

    public void checkAddBtnIsVisible() {
        assertTrue(driver.findElement(addButton).isDisplayed());
    }

    public void clickOnAddBtn() {
        driver.findElement(addButton).click();
    }
}
