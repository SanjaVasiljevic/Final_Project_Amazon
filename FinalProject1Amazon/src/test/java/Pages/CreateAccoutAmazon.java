package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccoutAmazon {
    public WebDriver driver;
    public WebDriverWait webDriverWait;

    @FindBy(id = "createAccountSubmit")
    WebElement creatAccountSubmit;
    public void clickCreatAccountButtom(){
        creatAccountSubmit.click();
    }

    @FindBy(id = "ap_customer_name")
    WebElement customerName;

    public void inputCustomerName(String cName){
        customerName.clear();
        customerName.sendKeys(cName);
    }
    @FindBy(id = "ap_email")
    WebElement customerEmail;

    public void inputEmail(String email){
        customerEmail.clear();
        customerEmail.sendKeys(email);
    }
    @FindBy(xpath = "//input[@id='ap_email']")
    WebElement customerPhone;

    public void inputPhone(String phone){
        customerPhone.clear();
        customerPhone.sendKeys(phone);
    }
    @FindBy(xpath= "//input[@id='ap_password']")
    WebElement password;
    public void inputPassword(String passWord){
        password.clear();
        password.sendKeys(passWord);
    }
    @FindBy(xpath = "//input[@id='ap_password_check']")
    WebElement passwordCheck;
    public void inputPasswordCheck(String passWord){
        passwordCheck.clear();
        passwordCheck.sendKeys(passWord);
    }

    @FindBy(id = "continue")
    WebElement continueButton;
    public void clickContinueButton(){
        continueButton.click();
    }
    @FindBy(id = "signInSubmit")
    WebElement signInSubmitButton;

    public void clickSignInSubmitButtom(){
        signInSubmitButton.click();
    }
    public CreateAccoutAmazon(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(this.driver,this);
    }
}
