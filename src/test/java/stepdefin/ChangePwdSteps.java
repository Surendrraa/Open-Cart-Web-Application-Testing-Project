package stepdefin;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.ChangePwdPage;

public class ChangePwdSteps { //by using extends keyword LoginBase class can Extends son code duplication decrease
    WebDriver driver;
    ChangePwdPage changePwdPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
    	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://naveenautomationlabs.com/opencart/");
        changePwdPage = new ChangePwdPage(driver);
    }

    @Test(dataProvider = "passwordData")
    public void testChangePassword(String email, String password, String newPassword, String confirmPassword) {
        changePwdPage.clickMyAccountLink();
        changePwdPage.clickLoginLink();
        changePwdPage.enterEmail(email);
        changePwdPage.enterPassword(password);
        changePwdPage.clickLoginButton();
        changePwdPage.clickChangePwdLink();
        changePwdPage.enterNewPassword(newPassword);
        changePwdPage.enterConfirmPassword(confirmPassword);
        changePwdPage.clickContinueButton();
        // Add assertions here to verify the password change
    }

    @DataProvider(name = "passwordData")
    public Object[][] providePasswordData() {
        return new Object[][] {
            {"cvsurendra2001@gmail.com", "Phani@123", "Phani@1234", "Phani@1234"},
            
        };
    }

    @AfterMethod
    public void tearDown() {
            driver.quit();
        
    }
}

