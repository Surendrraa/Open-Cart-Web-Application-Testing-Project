package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductComparePage {
    WebDriver driver;

    By searchBar = By.xpath("//input[@placeholder='Search']");
    By searchBtn = By.xpath("//button[contains(@class,'btn btn-default')]");
    By productCompareLink = By.xpath("//a[contains(text(),'Product Compare (0)')]");
    By iconMacBookProductCompare = By.xpath("(//i[@class='fa fa-exchange'])[1]");
    //By iconIphoneProductCompare = By.xpath("(//button[@data-original-title='Compare this Product'])[2]");

    public ProductComparePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchText(String productName) {
        driver.findElement(searchBar).clear();
        driver.findElement(searchBar).sendKeys(productName);
    }

    public void clickSearchButton() {
        driver.findElement(searchBtn).click();
    }   

    public void clickProductCompareIcon() {
        driver.findElement(iconMacBookProductCompare).click();
      
    }
}
