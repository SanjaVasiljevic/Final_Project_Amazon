package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.Keys.ENTER;

public class HomePageAmazon {
    public WebDriver driver;
    public WebDriverWait webDriverWait;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    WebElement signInButtom;
    public void clickSignInButtom(){
        signInButtom.click();
    }


    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBar;

    public void inputSearch(String bookName){
        searchBar.clear();
        searchBar.sendKeys(bookName);
        searchBar.sendKeys(ENTER);
    }


    public HomePageAmazon(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(this.driver,this);
    }

}
