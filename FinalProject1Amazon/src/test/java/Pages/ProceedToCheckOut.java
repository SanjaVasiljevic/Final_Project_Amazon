package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProceedToCheckOut {
    public WebDriver driver;
    public WebDriverWait webDriverWait;


    @FindBy(className = "a-button-input")
    WebElement proceedToCheckOutButton;

    public void clickProceedToCheckOutButton() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0,0)");
        Thread.sleep(2000);
        proceedToCheckOutButton.click();
    }

    public ProceedToCheckOut(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(this.driver,this);
    }
}
