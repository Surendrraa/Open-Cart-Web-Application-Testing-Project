package stepdefin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.CheckOutPage;


public class CheckOutSteps { //by using extends keyword LoginBase class can Extends son code duplication decrease
    WebDriver driver;
    CheckOutPage checkOutPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
    	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://naveenautomationlabs.com/opencart/");
        checkOutPage = new CheckOutPage(driver);
    }

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginData() {
        return new Object[][] {
            { "cvsurenra2001@gmail.com.com", "password1" },
            
        };
    }

    @Test(dataProvider = "loginDataProvider")
    public void testLogin(String email, String password) {
        checkOutPage.clickMyAccount();
        checkOutPage.clickLogin();
        checkOutPage.enterEmail(email);
        checkOutPage.enterPassword(password);
        checkOutPage.clickLoginButton();
        // Add assertions here to verify successful login
    }

    @Test(dependsOnMethods = "testLogin")
    public void testCheckOut() {
        checkOutPage.clickCheckOut();
        // Add assertions here to verify navigation to the checkout page
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
