package stepdefin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.ProductDisplayPage;

public class ProductDisplaySteps {
    WebDriver driver;
    ProductDisplayPage productDisplayPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
    	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://naveenautomationlabs.com/opencart/");
        productDisplayPage = new ProductDisplayPage(driver);
        Thread.sleep(3000);
    }

    @DataProvider(name = "productDetailsProvider")
    public Object[][] productDetails() {
        return new Object[][] {
            { "MacBook", "Apple", "Product 16", "600", "In Stock" }
        };
    }

    @Test(dataProvider = "productDetailsProvider")
    public void testProductDetails(String expectedName, String expectedBrand, String expectedCode, String expectedPoints, String expectedAvailability) throws InterruptedException {
       
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home"); 
        Thread.sleep(3000);
        productDisplayPage.clickProductImage();
        String actualName = productDisplayPage.getProductName();
        String actualBrand = productDisplayPage.getProductBrand();
        String actualCode = productDisplayPage.getProductCode();
        String actualPoints = productDisplayPage.getRewardPoints();
        String actualAvailability = productDisplayPage.getAvailability();

        assert actualName.equals(expectedName) : "Expected Product Name: " + expectedName + ", but found: " + actualName;
        assert actualBrand.equals(expectedBrand) : "Expected Product Brand: " + expectedBrand + ", but found: " + actualBrand;
        assert actualCode.equals(expectedCode) : "Expected Product Code: " + expectedCode + ", but found: " + actualCode;
        assert actualPoints.equals(expectedPoints) : "Expected Reward Points: " + expectedPoints + ", but found: " + actualPoints;
        assert actualAvailability.equals(expectedAvailability) : "Expected Availability: " + expectedAvailability + ", but found: " + actualAvailability;
    }

    @AfterClass
    public void tearDown() {
            driver.quit();
        
    }
}
