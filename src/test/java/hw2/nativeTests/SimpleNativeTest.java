package hw2.nativeTests;

import hw2.Hooks;
import org.testng.annotations.*;

import java.io.IOException;

@Test(groups = "native")
public class SimpleNativeTest extends Hooks {

    protected SimpleNativeTest() throws IOException {
        super();
    }

    @Test(description = "Click on button 'Add contact' and check result")
    public void simplestTest() throws Exception {

        //1. Check that "Add Contact" button is visible
        contactManagerPage.checkAddBtnIsVisible();

        //2. Click on "Add Contact" button
        contactManagerPage.clickOnAddBtn();

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
