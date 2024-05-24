package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDisplayPage {
    WebDriver driver;
    By imgProductClick = By.xpath("//img[@alt='MacBook']");
    By productName = By.xpath("//h1[@class='product-title']");
    By productBrand = By.xpath("//li[contains(text(), 'Brand:')]/a");
    By productCode = By.xpath("//li[contains(text(), 'Product Code:')]/following-sibling::li[contains(text(), 'Product 16')]");
    By rewardPoints = By.xpath("//li[contains(text(), 'Reward Points:')]/following-sibling::li[contains(text(), '600')]");
    By availability = By.xpath("//li[contains(text(), 'Availability:')]/following-sibling::li[contains(text(), 'In Stock')]");

    public ProductDisplayPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProductImage() {
         driver.findElement(imgProductClick).click();
    }
    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public String getProductBrand() {
        return driver.findElement(productBrand).getText();
    }

    public String getProductCode() {
        return driver.findElement(productCode).getText();
    }

    public String getRewardPoints() {
        return driver.findElement(rewardPoints).getText();
    }

    public String getAvailability() {
        return driver.findElement(availability).getText();
    }
}
