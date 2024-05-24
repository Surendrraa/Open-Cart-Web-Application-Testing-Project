package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage { //by using extends keyword LoginBase class can Extends son code duplication decrease
    WebDriver driver;

    // Locators
    By myAccountLink = By.linkText("My Account");
    By loginLink = By.linkText("Login");
    By txtEmail = By.id("input-email");
    By txtPassword = By.id("input-password");
    By btnLogin = By.xpath("//input[@value='Login']");
    By searchBar = By.xpath("//input[@placeholder='Search']");
    By searchBtn = By.xpath("//button[contains(@class,'btn btn-default')]");
    By addCartBtn = By.xpath("(//span[text()='Add to Cart'])[2]");
    By shoppingCartIcon = By.xpath("//span[text()='Shopping Cart']");

    // Constructor
    public AddToCartPage(WebDriver driver) {
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

    public void searchForProduct(String productName) {
        driver.findElement(searchBar).sendKeys(productName);
        driver.findElement(searchBtn).click();
    }

    public void clickAddToCart() {
        driver.findElement(addCartBtn).click();
    }

    public void clickShoppingCartIcon() {
        driver.findElement(shoppingCartIcon).click();
    }
}
