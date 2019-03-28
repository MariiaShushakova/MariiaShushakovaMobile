package hw2.nativeTests;

import org.testng.annotations.*;
import pageObjects.AddContactPage;
import pageObjects.ContactManager;
import setup.DriverSetup;

import java.io.IOException;

@Test(groups = "native")
public class SimpleNativeTest extends DriverSetup {
    private ContactManager homePage;
    private AddContactPage addContactPage;

    protected SimpleNativeTest() throws IOException {
        super();
    }

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

    @Test(description = "Click on button 'Add contact' and check result")
    public void simplestTest() throws Exception {

        //1. Check that "Add Contact" button is visible
        homePage.checkAddBtnIsVisible();

        //2. Click on "Add Contact" button
        homePage.clickOnAddBtn();

        //3. Check "Target Account" field text
        addContactPage.checkTargetAccountFieldText();

        //4. Check that "Target Account" dropdown menu is Visible
        addContactPage.checkAccountDropDownMenuIsVisible();

        //5. Check that "Contact Name" field is Visible
        addContactPage.checkContactNameFieldIsVisible();

        //6. Check that "Contact Phone" field is visible
        addContactPage.checkContactPhoneFieldIsVisible();

        //7. Check that "Contact E-mail" field is visible
        addContactPage.checkEmailFieldIsVisible();

        //8. Hide the keyboard
        addContactPage.hideKeyboard();

        System.out.println("Simple Native test complete");
    }
}
