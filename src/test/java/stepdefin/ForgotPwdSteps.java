package stepdefin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.ForgotPwdPage;

public class ForgotPwdSteps { //by using extends keyword LoginBase class can Extends son code duplication decrease
    WebDriver driver;
    ForgotPwdPage forgotPwdPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
    	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://naveenautomationlabs.com/opencart/");
        forgotPwdPage = new ForgotPwdPage(driver);
    }

    @DataProvider(name = "emailProvider")
    public Object[][] emailData() {
        return new Object[][] {
            { "karthik2001@gmail.com" },
            { "user@example.com" },
            { "admin@example.com" }
        };
    }

    @Test(dataProvider = "emailProvider")
    public void testForgottenPassword(String email) {
        forgotPwdPage.clickMyAccount();
        forgotPwdPage.clickLogin();
        forgotPwdPage.clickForgottenPassword();
        forgotPwdPage.setEmail(email);
        forgotPwdPage.clickContinue();
    }

    @AfterClass
    public void tearDown() {
          driver.quit();
        
    }
}
