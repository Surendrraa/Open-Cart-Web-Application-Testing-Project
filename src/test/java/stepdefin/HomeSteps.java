package stepdefin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.HomePage;

public class HomeSteps { //by using extends keyword LoginBase class can Extends son code duplication decrease
	WebDriver driver;
	HomePage homePage;

	@BeforeClass
	public void setUp() throws InterruptedException {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://naveenautomationlabs.com/opencart/");
		homePage = new HomePage(driver);
	}

	@DataProvider(name = "loginDataProvider")
	public Object[][] loginData() {
		return new Object[][] {
			{ "cvsurendra2001@gmail.com", "Phani@123" },

		};
	}

	@Test(dataProvider = "loginDataProvider")
	public void testLogin(String email, String password) {
		homePage.clickMyAccount();
		homePage.clickLogin();
		homePage.enterEmail(email);
		homePage.enterPassword(password);
		homePage.clickLoginButton();
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
		homePage.searchForProduct(productName);
		// Add assertions here to verify search results
	}

	@Test
	public void testAddToWishlist() {
		homePage.clickWishlistIcon();
		// Add assertions here to verify item was added to wishlist
	}

	@Test
	public void testWishlistMenuIcon() {
		homePage.clickWishlistMenuIcon();
		// Add assertions here to verify navigation to the wishlist page
	}

	@Test
	public void testHomeIcon() throws InterruptedException {
		Thread.sleep(5000);
		homePage.clickHomeIcon();
		// Add assertions here to verify navigation to the home page
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
