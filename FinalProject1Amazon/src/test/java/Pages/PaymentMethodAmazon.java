package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentMethodAmazon {
    public WebDriver driver;
    public WebDriverWait webDriverWait;

    @FindBy(xpath = "//span[@id='apx-add-credit-card-action-test-id']")
    WebElement addCreditCart;
    public void clickAddCreditCart(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addCreditCart);
        addCreditCart.click();

    }
    @FindBy(id = "pp-QvKznd-15")
    WebElement cartNumber;
    public void inputCartNumber(String number){
        cartNumber.sendKeys(number);
    }
    @FindBy(id="pp-QvKznd-17")
    WebElement nameOnCart;
    public void inputNameOnCart(String name){
        nameOnCart.sendKeys(name);
    }
    @FindBy(id="pp-QvKznd-18_7")
    WebElement expirationDateMonth;
    public void months(){
        expirationDateMonth.click();
    }
    @FindBy(id = "pp-QvKznd-20_5")
    WebElement expirationDateYear;
    public void year(){
        expirationDateYear.click();
    }
    @FindBy(id = "pp-b310D1-13")
    WebElement addYourCart;
    public void clickAddYourCart(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addYourCart);
        addYourCart.click();
    }
    @FindBy(xpath= "//*[@id=\"pp-QvKznd-14\"]/div/div/div/h4")
    WebElement error;
    public void errorMessage(){
        error.getText();
    }



    public PaymentMethodAmazon(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(this.driver,this);
    }
}
