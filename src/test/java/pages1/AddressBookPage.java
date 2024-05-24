package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressBookPage { //by using extends keyword LoginBase class can Extends son code duplication decrease
    WebDriver driver;

    public AddressBookPage(WebDriver driver) {
        this.driver = driver;
    }

    By myAccountLink = By.linkText("My Account");
    By loginLink = By.linkText("Login");
    By txtEmail = By.id("input-email");
    By txtPassword = By.id("input-password");
    By btnLogin = By.xpath("//input[@value='Login']");
    By addressBookLink = By.linkText("Address Book");
    By newAddressBtn = By.linkText("New Address");
    By firstName = By.name("firstname");
    By lastName = By.name("lastname");
    By companyName = By.name("company");
    By addressLine_1 = By.name("address_1");
    By addressLine_2 = By.name("address_2");
    By cityName = By.id("input-city");
    By postalCode = By.id("input-postcode");
    By countryDropDown = By.id("input-country");
    By countrySelect = By.xpath("//select[@id='input-country']/option[text()='India']");
    By stateDropDown = By.id("input-zone");
    By stateSelect = By.xpath("//select[@id='input-zone']/option[text()='Andhra Pradesh']");
    By radioBtn = By.xpath("(//input[@type='radio'])[1]");
    By continueBtn = By.xpath("//input[@value='Continue']");

    public void clickMyAccount() {
        driver.findElement(myAccountLink).click();
    }

    public void clickLogin() {
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

    public void clickAddressBook() {
        driver.findElement(addressBookLink).click();
    }

    public void clickNewAddress() {
        driver.findElement(newAddressBtn).click();
    }

    public void setFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void setLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void setCompanyName(String cname) {
        driver.findElement(companyName).sendKeys(cname);
    }

    public void setAddressLine1(String addr1) {
        driver.findElement(addressLine_1).sendKeys(addr1);
    }

    public void setAddressLine2(String addr2) {
        driver.findElement(addressLine_2).sendKeys(addr2);
    }

    public void setCityName(String city) {
        driver.findElement(cityName).sendKeys(city);
    }

    public void setPostalCode(String pcode) {
        driver.findElement(postalCode).sendKeys(pcode);
    }

    public void selectCountry() {
        driver.findElement(countryDropDown).click();
        driver.findElement(countrySelect).click();
    }

    public void selectState() {
        driver.findElement(stateDropDown).click();
        driver.findElement(stateSelect).click();
    }

    public void selectRadioButton() {
        driver.findElement(radioBtn).click();
    }

    public void clickContinueButton() {
        driver.findElement(continueBtn).click();
    }
}
