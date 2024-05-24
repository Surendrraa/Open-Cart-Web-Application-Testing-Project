package stepdefin;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.MyAccountInfoPage;

public class MyAccountInfoSteps { //by using extends keyword LoginBase class can Extends son code duplication decrease
    WebDriver driver;
    pages1.MyAccountInfoPage myAccountInfoPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
    	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://naveenautomationlabs.com/opencart/");
        myAccountInfoPage = new MyAccountInfoPage(driver);
    }

    @Test(dataProvider = "accountData")
    public void testEditAccount(String email, String password, String newLastName) {
        myAccountInfoPage.clickMyAccountLink();
        myAccountInfoPage.clickLoginLink();
        myAccountInfoPage.enterEmail(email);
        myAccountInfoPage.enterPassword(password);
        myAccountInfoPage.clickLoginButton();
        myAccountInfoPage.clickEditAccountInfo();
        myAccountInfoPage.clickEditAccount();
        myAccountInfoPage.enterLastName(newLastName);
        myAccountInfoPage.clickContinueButton();
        // Add assertions here to verify the changes
    }

    @DataProvider(name = "accountData")
    public Object[][] provideAccountData() {
        return new Object[][] {
            {"cvsurendra2001@gmail.com", "Phani@123", "Surendraa"},
           
        };
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
