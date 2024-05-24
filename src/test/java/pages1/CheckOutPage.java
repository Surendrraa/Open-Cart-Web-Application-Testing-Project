package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage { //by using extends keyword LoginBase class can Extends son code duplication decrease
    WebDriver driver;

    // Locators
    By myAccountLink = By.linkText("My Account");
    By loginLink = By.linkText("Login");
    By txtEmail = By.id("input-email");
    By txtPassword = By.id("input-password");
    By btnLogin = By.xpath("//input[@value='Login']");
    By checkOut = By.xpath("//span[text()='Checkout']");

    // Constructor
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with elements
    public void clickMyAccount() {
        driver.findElement(myAccountLink).click();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void enterEmail(String email) {
        driver.findElement(txtEmail).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(btnLogin).click();
    }

    public void clickCheckOut() {
        driver.findElement(checkOut).click();
    }
}
