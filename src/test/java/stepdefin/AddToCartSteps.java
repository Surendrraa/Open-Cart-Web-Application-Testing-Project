package stepdefin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.AddToCartPage;

public class AddToCartSteps { //by using extends keyword LoginBase class can Extends son code duplication decrease
	WebDriver driver;
	AddToCartPage addToCartPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://naveenautomationlabs.com/opencart/");
		addToCartPage = new AddToCartPage(driver);
	}

	@DataProvider(name = "loginDataProvider")
	public Object[][] loginData() {
		return new Object[][] {
			{ "cvsurendra2001@gmail.com", "Phani@123" },

		};
	}

	@Test(dataProvider = "loginDataProvider")
	public void testLogin(String email, String password) {
		addToCartPage.clickMyAccount();
		addToCartPage.clickLogin();
		addToCartPage.enterEmail(email);
		addToCartPage.enterPassword(password);
		addToCartPage.clickLoginButton();
		// Add assertions here to verify successful login
	}

	@DataProvider(name = "searchDataProvider")
	public Object[][] searchData() {
		return new Object[][] {
			{ "Mac" },

		};
	}

	@Test(dataProvider = "searchDataProvider")
	public void testSearch(String productName) {
		addToCartPage.searchForProduct(productName);
		// Add assertions here to verify search results
	}

	@Test
	public void testAddToCart() {
		addToCartPage.clickAddToCart();
		// Add assertions here to verify item was added to cart
	}

	@Test
	public void testShoppingCartIcon() {
		addToCartPage.clickShoppingCartIcon();
		// Add assertions here to verify navigation to the shopping cart page
	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}
}
