package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Cart {
    public WebDriver driver;
    public WebDriverWait webDriverWait;
    @FindBy(className = "a-color-link")
    WebElement deleteBook2;

    public void clickDeleteBook2() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", deleteBook2);
        deleteBook2.click();
    }

    @FindBy(className = "a-dropdown-label")
    WebElement dropDownButton;

    public void clickDropDownButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", dropDownButton);
        dropDownButton.click();
    }

    @FindBy(xpath = "//a[@id='quantity_2']")
    WebElement dropdownSelect;

    public void clickDropdownSelectQuantity2() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", dropdownSelect);
        dropdownSelect.click();

    }


    public Cart(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(this.driver, this);
    }
}
