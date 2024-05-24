package pages1;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountInfoPage {
    WebDriver driver;

    // Constructor
    public MyAccountInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    // Web Elements
    By myAccountLink = By.linkText("My Account");
    By loginLink = By.linkText("Login");
    By txtEmail = By.id("input-email");
    By txtPassword = By.id("input-password");
    By btnLogin = By.xpath("//input[@value='Login']");
    By editAccountInfo = By.linkText("Edit your account information");
    By editAccount = By.xpath("//a[contains(text(),'Edit Account')]");
    By lastName = By.id("input-lastname");
    By clickContinue = By.xpath("//input[@value='Continue']");

    // Methods to interact with the elements
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

    public void clickEditAccountInfo() {
        driver.findElement(editAccountInfo).click();
    }

    public void clickEditAccount() {
        driver.findElement(editAccount).click();
    }

    public void enterLastName(String lastNameValue) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lastNameValue);
    }

    public void clickContinueButton() {
        driver.findElement(clickContinue).click();
    }
}
