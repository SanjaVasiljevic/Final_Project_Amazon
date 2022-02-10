package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectAShippingAddressAmazon {
    public WebDriver driver;
    public WebDriverWait webDriverWait;

    @FindBy(xpath = "//*[@id=\"address-ui-widgets-countryCode\"]/span/span")
    WebElement dropDownCountry;

    public void clickOnDropDown(){
        dropDownCountry.click();
    }
    @FindBy(xpath = "//a[contains(text(),'Serbia')]")
    WebElement selecySrbia;
    public void clickSrbia(){
        selecySrbia.click();
    }
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
    WebElement fullName;
    public void inputFullName(String fn){
        fullName.sendKeys(fn);
    }
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
    WebElement streetAddress;
    public void inputStreet(String streetA){
        streetAddress.sendKeys(streetA);
    }
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine2']")
    WebElement apartment;
    public void inputAppartmentNum(String num){
        apartment.sendKeys(num);
    }
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressCity']")
    WebElement city;
    public void inputCity(String imputCity){
        city.sendKeys(imputCity);
    }
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressStateOrRegion']")
    WebElement region;
    public void inputRegion(String inputRegion){
        region.sendKeys(inputRegion);
    }
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPostalCode']")
    WebElement zipCode;
    public void inputZipCode(String zip){
        zipCode.sendKeys(zip);
    }
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
    WebElement phoneNumber;
    public void inputPhoneNumber(String phone){
        phoneNumber.sendKeys(phone);
    }
    @FindBy(xpath = "//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")
    WebElement useThisAddressButton;

    public void clickUseThisAddressButton() throws InterruptedException {
        Thread.sleep(2000);
        useThisAddressButton.click();
    }

    public SelectAShippingAddressAmazon(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(this.driver, this);
    }
}
