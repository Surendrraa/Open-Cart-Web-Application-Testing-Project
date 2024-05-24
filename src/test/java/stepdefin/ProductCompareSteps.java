package stepdefin;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.ProductComparePage;

public class ProductCompareSteps {
	WebDriver driver;
	ProductComparePage productComparePage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://naveenautomationlabs.com/opencart/");
		productComparePage = new ProductComparePage(driver);
	}

	@DataProvider(name = "productDataProvider")
	public Object[][] productData() {
		return new Object[][] {
			{ "Mac" },
			
		};
	}

	@Test(dataProvider = "productDataProvider")
	public void testProductComparison(String productName) throws InterruptedException {
		productComparePage.enterSearchText(productName);
		productComparePage.clickSearchButton();
		productComparePage.clickProductCompareIcon();
		Thread.sleep(5000);
		
	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();

	}
}


