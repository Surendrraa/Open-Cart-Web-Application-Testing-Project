package stepdefin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.MyAccountPage;

public class MyAccountSteps { //by using extends keyword LoginBase class can Extends son code duplication decrease
    WebDriver driver;
    MyAccountPage myAccountPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
    	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://naveenautomationlabs.com/opencart/");
        myAccountPage = new MyAccountPage(driver);
    }

    @DataProvider(name = "clickDataProvider")
    public Object[][] clickData() {
        return new Object[][] {
            { "clickMyAccountLink" },
            { "clickLoginLink" },
            { "clickMyAccountRightColumn" },
            { "clickMyAccountFooter" }
        };
    }

    @Test(dataProvider = "clickDataProvider")
    public void testClicks(String methodName) throws Exception {
        switch (methodName) {
            case "clickMyAccountLink":
                myAccountPage.clickMyAccountLink();
                // Add assertions to verify navigation
                break;
            case "clickLoginLink":
                myAccountPage.clickLoginLink();
                // Add assertions to verify navigation
                break;
            case "clickMyAccountRightColumn":
                myAccountPage.clickMyAccountRightColumn();
                // Add assertions to verify navigation
                break;
            case "clickMyAccountFooter":
                myAccountPage.clickMyAccountFooter();
                // Add assertions to verify navigation
                break;
            default:
                throw new Exception("Invalid method name");
        }
    }

    @AfterClass
    public void tearDown() {
       
            driver.quit();
        
    }
}
