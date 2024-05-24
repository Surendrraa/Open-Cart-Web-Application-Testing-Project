package stepdefin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.SearchBarPage;

public class SearchBarSteps {
    WebDriver driver;
    SearchBarPage searchBarPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
    	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://naveenautomationlabs.com/opencart/");
		searchBarPage = new SearchBarPage(driver);
    }

    @DataProvider(name = "searchDataProvider")
    public Object[][] searchData() {
        return new Object[][] {
            { "iMac" },
            { "creative cars" },
            { "" },
            { "Mac" },
            { "iLife" }
        };
    }

    @Test(dataProvider = "searchDataProvider")
    public void testSearch(String productName) {
        searchBarPage.enterSearchText(productName);
        searchBarPage.clickSearchButton();
        
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

