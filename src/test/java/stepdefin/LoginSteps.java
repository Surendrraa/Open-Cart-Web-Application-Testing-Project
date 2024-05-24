package stepdefin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.LoginPage;


public class LoginSteps { //by using extends keyword LoginBase class can Extends son code duplication decrease

	WebDriver driver;
	LoginPage loginPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://naveenautomationlabs.com/opencart/");
		loginPage = new LoginPage(driver);
	}

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
		return new Object[][] {
			{ "cvsurendra2001@gmail.com", "Phani@123@123" }, // Correct credentials
			{ "invalidemail@example.com", "Invalid@123" }, // Invalid credentials (both invalid email and invalid password)
			{ "invalidemail@example.com", "Phani@123" }, // Invalid email address and valid password
			{ "cvsurendra2001@gmail.com", "Invalid@123" }, // Valid email address and invalid password
			{ "", "" }, // No credentials provided
			{"@#$&*(", "#$%#@12"}, //Different Symbols
						
		};
	}

	@Test(dataProvider = "loginData")
	public void loginTest(String email, String password) throws InterruptedException {
		Thread.sleep(3000);
		loginPage.clickMyAccount();
		loginPage.clickLoginLink();
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}



