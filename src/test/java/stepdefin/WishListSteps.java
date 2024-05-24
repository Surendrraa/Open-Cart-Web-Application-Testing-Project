package stepdefin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.WishListPage;

public class WishListSteps {
    WebDriver driver;
    WishListPage wishListPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        // Set the path for the ChromeDriver
    	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://naveenautomationlabs.com/opencart/");
        wishListPage = new WishListPage(driver);
    }

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginData() {
        return new Object[][] {
            { "cvsurendra2001@gmail.com", "Phani@123" },
           
        };
    }

    @Test(dataProvider = "loginDataProvider")
    public void testLogin(String email, String password) {
        wishListPage.clickMyAccount();
        wishListPage.clickLogin();
        wishListPage.enterEmail(email);
        wishListPage.enterPassword(password);
        wishListPage.clickLoginButton();
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
        wishListPage.searchForProduct(productName);
        // Add assertions here to verify search results
    }

    @Test
    public void testAddToWishlist() {
        wishListPage.clickWishlistIcon();
        // Add assertions here to verify item was added to wishlist
    }

    @Test
    public void testWishlistMenuIcon() {
        wishListPage.clickWishlistMenuIcon();
        // Add assertions here to verify navigation to the wishlist page
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
