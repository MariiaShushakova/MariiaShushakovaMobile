package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactManager {
    //String pageTitle = "Contact Manager";
    private AppiumDriver driver;
    //private By title = By.id("android:id/title");
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
