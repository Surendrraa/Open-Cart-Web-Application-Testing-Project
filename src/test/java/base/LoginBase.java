package base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginBase {
	WebDriver driver;
    public void Login() throws InterruptedException {
    	WebDriverManager.edgedriver().setup();
         driver = new EdgeDriver();
         driver.manage().window().maximize();
 		Thread.sleep(3000);

        try {
            // Open the website
            driver.get("https://naveenautomationlabs.com/opencart/");

            // Click on the "My Account" link
            WebElement myAccountLink = driver.findElement(By.linkText("My Account"));
            myAccountLink.click();

            // Click on the "Login" link
            WebElement loginLink = driver.findElement(By.linkText("Login"));
            loginLink.click();

            // Enter email address
            WebElement txtEmail = driver.findElement(By.id("input-email"));
            txtEmail.sendKeys("cvsurenra2001@gmail.com");

            // Enter password
            WebElement txtPassword = driver.findElement(By.id("input-password"));
            txtPassword.sendKeys("Phani@1234");

            // Click on the "Login" button
            WebElement btnLogin = driver.findElement(By.xpath("//input[@value='Login']"));
            btnLogin.click();

            // Optionally, add assertions or further interactions here
            // For example, check if login was successful by verifying the presence of a logout button
            WebElement logoutButton = driver.findElement(By.linkText("Logout"));
            if (logoutButton.isDisplayed()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed.");
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
