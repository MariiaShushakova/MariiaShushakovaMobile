package hw2;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.AddContactPage;
import pageObjects.ContactManager;
import pageObjects.HomePage;
import setup.DriverSetup;


@Test(groups = {"web", "native"})
public class Hooks extends DriverSetup {
    public ContactManager homePage;
    public AddContactPage addContactPage;

    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareDriver();
        homePage = new ContactManager(driver());
        addContactPage = new AddContactPage(driver());
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
    }
}
