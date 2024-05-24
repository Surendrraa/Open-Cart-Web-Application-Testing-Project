package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    WebDriver driver;

    By myAccountLink = By.linkText("My Account");
    By loginLink = By.linkText("Login");
    By txtEmail = By.id("input-email");
    By txtPassword = By.id("input-password");
    By btnLogin = By.xpath("//input[@value='Login']");
    By myAccount = By.xpath("//span[text()='My Account']");
    By logout = By.linkText("Logout");
    By rightColumnLogout = By.xpath("//aside[@id='column-right']//a[contains(@href, 'route=account/logout')]");

    

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMyAccountLink() {
        driver.findElement(myAccountLink).click();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void setEmail(String email) {
        driver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(btnLogin).click();
    }

    public void clickMyAccount() {
        driver.findElement(myAccount).click();
    }

    public void clickLogout() {
        driver.findElement(logout).click();
    }
    
    public void clickRightColumnLogout() {
        driver.findElement(rightColumnLogout).click();
    }
}
