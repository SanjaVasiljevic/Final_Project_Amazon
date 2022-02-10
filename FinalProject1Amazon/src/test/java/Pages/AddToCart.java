package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.Keys.ENTER;

public class AddToCart {
    public WebDriver driver;
    public WebDriverWait webDriverWait;


    @FindBy(linkText = "Learn Selenium: Build data-driven test frameworks for mobile and web applications with Selenium Web Driver 3")
    WebElement book1AddToCart;

    public void clickOn1Book() {
        book1AddToCart.click();
    }

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCart;

    public void clickAddToCartButton() throws InterruptedException {
        addToCart.sendKeys(ENTER);
    }

    @FindBy(xpath = "//span[contains(text(),'Roots in Reverse: Senegalese Afro-Cuban Music and ')]")
    WebElement book2AddToCart;

    public void clickOn2Book() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", book2AddToCart);
        Thread.sleep(2000);
        book2AddToCart.click();
    }

    @FindBy(id = "nav-cart-count")
    WebElement cart;

    public void clickCart() {
        cart.click();
    }
    @FindBy(xpath = "//body/div[@id='a-page']/div[@id='sw-full-view-container']/div[@id='sw-full-view']/div[@id='sw-atc-confirmation']/div[@id='sw-atc-actions']/div[@id='sw-atc-buy-box']/span[@id='sw-gtc']/span[1]/a[1]")
    WebElement goToCartButton;

    public void clickGoToCart(){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", goToCartButton);
        goToCartButton.click();
    }


    public AddToCart(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(this.driver, this);
    }
}
