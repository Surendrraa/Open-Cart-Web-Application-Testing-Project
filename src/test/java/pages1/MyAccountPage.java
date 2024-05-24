package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    WebDriver driver;

    // Locators
    By myAccountLink = By.linkText("My Account");
    By loginLink = By.linkText("Login");
    By myAccountRightColumnClick = By.xpath("(//a[@class='list-group-item']/following-sibling::a)[3]");
    By myAccountFooterClick = By.xpath("//a[contains(text(),'My Account')]");

    // Constructor
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with elements
    public void clickMyAccountLink() {
        driver.findElement(myAccountLink).click();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void clickMyAccountRightColumn() {
        driver.findElement(myAccountRightColumnClick).click();
    }

    public void clickMyAccountFooter() {
        driver.findElement(myAccountFooterClick).click();
    }
}
