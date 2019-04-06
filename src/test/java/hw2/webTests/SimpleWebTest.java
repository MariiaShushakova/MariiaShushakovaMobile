package hw2.webTests;

import hw2.Hooks;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import setup.DriverSetup;
import setup.HttpResponseCode;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

@Test(groups = "web")
public class SimpleWebTest extends Hooks {

    protected SimpleWebTest() throws IOException {
        super();
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        int statusCode;
        statusCode = new HttpResponseCode().httpResponseCodeViaGet("https://www.iana.org/");
        assertEquals(200,statusCode);

        //1. Open site
        homePage.open(SUT, driverWait());

        //2. Check page Title
        homePage.checkPageTitle();

        //3. Check the panels are visible
        homePage.checkMainPanelsAreVisible();

        System.out.println("Web test complete");
    }
}
