package stepdefin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages1.AddressBookPage;

public class AddressBookSteps { //by using extends keyword LoginBase class can Extends son code duplication decrease
    WebDriver driver;
    AddressBookPage addressBookPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
    	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://naveenautomationlabs.com/opencart/");
        addressBookPage = new AddressBookPage(driver);
    }

    @Test(dataProvider = "addressData")
    public void addNewAddress(String email, String password, String fname, String lname, String company, String addr1, String addr2, String city, String pcode) {
        addressBookPage.clickMyAccount();
        addressBookPage.clickLogin();
        addressBookPage.setEmail(email);
        addressBookPage.setPassword(password);
        addressBookPage.clickLoginButton();
        addressBookPage.clickAddressBook();
        addressBookPage.clickNewAddress();
        addressBookPage.setFirstName(fname);
        addressBookPage.setLastName(lname);
        addressBookPage.setCompanyName(company);
        addressBookPage.setAddressLine1(addr1);
        addressBookPage.setAddressLine2(addr2);
        addressBookPage.setCityName(city);
        addressBookPage.setPostalCode(pcode);
        addressBookPage.selectCountry();
        addressBookPage.selectState();
        addressBookPage.selectRadioButton();
        addressBookPage.clickContinueButton();
    }

    @DataProvider(name = "addressData")
    public Object[][] getAddressData() {
        return new Object[][] {
            {"cvsurendra2001@gmail.com", "Phani@1234", "John", "Doe", "tcs", "123 Street", "Apt 4", "Banglore", "513450"},
            // Add more data sets here
        };
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

