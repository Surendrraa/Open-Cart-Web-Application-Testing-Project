package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPwdPage {
    WebDriver driver;

    By myAccountLink = By.linkText("My Account");
    By loginLink = By.linkText("Login");
    By forgetPwdLink = By.linkText("Forgotten Password");
    By txtEmail = By.id("input-email");
    By btnContinue = By.xpath("//input[@class='btn btn-primary']");

    public ForgotPwdPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMyAccount() {
        driver.findElement(myAccountLink).click();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void clickForgottenPassword() {
        driver.findElement(forgetPwdLink).click();
    }

    public void setEmail(String email) {
        driver.findElement(txtEmail).sendKeys(email);
    }

    public void clickContinue() {
        driver.findElement(btnContinue).click();
    }
}

