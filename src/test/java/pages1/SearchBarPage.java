package pages1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBarPage {
    WebDriver driver;

    By searchBar = By.xpath("//input[@placeholder='Search']");
    By searchBtn = By.xpath("//button[contains(@class,'btn btn-default')]");

    public SearchBarPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchText(String productName) {
        driver.findElement(searchBar).clear();
        driver.findElement(searchBar).sendKeys(productName);
    }

    public void clickSearchButton() {
        driver.findElement(searchBtn).click();
    }
}

