package hw2.webTests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import setup.DriverSetup;
import setup.HttpResponseCode;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class SimpleWebTest extends DriverSetup {
    HomePage homePage;

    protected SimpleWebTest() throws IOException {
        super();
    }

    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareDriver();
        homePage = new HomePage(driver());
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
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
