package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePwdPage { //by using extends keyword LoginBase class can Extends son code duplication decrease
    WebDriver driver;

    By myAccountLink = By.linkText("My Account");
    By loginLink = By.linkText("Login");
    By txtEmail = By.id("input-email");
    By txtPassword = By.id("input-password");
    By btnLogin = By.xpath("//input[@value='Login']");
    By changePwdLink = By.linkText("Change your password");
    By changePwd = By.xpath("(//input[@type='password'])[1]");
    By confirmPwd = By.xpath("(//input[@type='password'])[2]");
    By continueBtn = By.xpath("//input[@value='Continue']");

    public ChangePwdPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMyAccountLink() {
        driver.findElement(myAccountLink).click();
    }

    public void clickLoginLink() {
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

    public void clickChangePwdLink() {
        driver.findElement(changePwdLink).click();
    }

    public void enterNewPassword(String newPassword) {
        driver.findElement(changePwd).sendKeys(newPassword);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPwd).sendKeys(confirmPassword);
    }

    public void clickContinueButton() {
        driver.findElement(continueBtn).click();
    }
}
