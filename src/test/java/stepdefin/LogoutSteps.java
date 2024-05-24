package stepdefin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.LogoutPage;

public class LogoutSteps {
	WebDriver driver;
	LogoutPage logoutPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://naveenautomationlabs.com/opencart/");
		logoutPage = new LogoutPage(driver);
	}

	@DataProvider(name = "loginDataProvider")
	public Object[][] loginData() {
		return new Object[][] {
			{ "cvsurendra2001@gmail.com", "Phani@123" },
			{ "cvsurendra2001@gmail.com", "Phani@123" },

		};
	}

	@Test(dataProvider = "loginDataProvider")
	public void testLogout(String email, String password) throws InterruptedException {
		// Login
		logoutPage.clickMyAccountLink();
		logoutPage.clickLoginLink();
		logoutPage.setEmail(email);
		logoutPage.setPassword(password);
		logoutPage.clickLoginButton();

		// Logout using the first option
		logoutPage.clickMyAccount();
		logoutPage.clickLogout();

		// Re-login for testing the second logout option
		logoutPage.clickMyAccountLink();
		logoutPage.clickLoginLink();
		logoutPage.setEmail(email);
		logoutPage.setPassword(password);
		logoutPage.clickLoginButton();
		Thread.sleep(3000);
		// Logout using the second option
		logoutPage.clickRightColumnLogout();
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}


