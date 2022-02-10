package Test;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class TestAmazon {
    public WebDriver driver;
    public WebDriverWait webDriverWait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    @BeforeMethod
    public void setUpPage() {
        driver.navigate().to("https://www.amazon.com/");
    }

    /**
     * Test case 1: Positive Creat Account at www.amazon.com
     * 1.Open page
     * 2.Click Sing in button
     * 3.Click Creat Account buttome
     * 4.Input username "salsita" into Username field
     * 5.Input Email nekaproba21@gmail.com into Email field
     * 6.Input password ITbootcamp@21 into Password field
     * 7.Input password check ITbootcamp@21 into Password Check field
     * 8.Click on Continue button
     * 9.Verify emila by otp 185191
     * 10.Enter phone number +381604046***
     * 11.enter otp 222635
     * 5.Verify new page URL contains
     * 6.Verify new page contains expected text ('....')
     */

   /* @Test
    public void creatAccountWithValidInput() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com/");
        HomePageAmazon homePage= new HomePageAmazon(driver,webDriverWait);
        CreateAccoutAmazon createAccoutAmazon=new CreateAccoutAmazon(driver,webDriverWait);
        homePage.clickSignInButtom();
        createAccoutAmazon.clickCreatAccountButtom();
        String validUserName="salsita";
        String validEmail="nekaproba21@gmail.com";
        String validPassword="ITbootcamp@21";
        String validPasswordCheck="ITbootcamp@21";
        createAccoutAmazon.inputCustomerName(validUserName);
        createAccoutAmazon.inputEmail(validEmail);
        createAccoutAmazon.inputPassword(validPassword);
        createAccoutAmazon.inputPasswordCheck(validPasswordCheck);
        createAccoutAmazon.clickContinueButton();
        Thread.sleep(20000);
        //webSite has Captcha and that have to do manuel
        //verify emila by otp 185191
        //enter phone number +381604046***
        //enter otp 222635

    }*/
    public void singIn() {
        HomePageAmazon homePage = new HomePageAmazon(driver, webDriverWait);
        CreateAccoutAmazon createAccoutAmazon = new CreateAccoutAmazon(driver, webDriverWait);
        homePage.clickSignInButtom();
        String validEmail = "nekaproba21@gmail.com";
        String validPassword = "ITbootcamp@21000";
        createAccoutAmazon.inputEmail(validEmail);
        createAccoutAmazon.clickContinueButton();
        createAccoutAmazon.inputPassword(validPassword);
        createAccoutAmazon.clickSignInSubmitButtom();
    }

    /**
     * Test case 2: Positive search input at www.amazon.com
     * 1.Open page
     * 2.Click Sing in button
     * 3.Input username "salsita" into Username field
     * 4.Input password ITbootcamp@21 into Password field
     * 5.Click on SignIn button
     * 9.Input at searBar book name "selenium testing"
     * 10.Enter phone number +381604046***
     * 11.Enter otp 222635
     * 5.Verify at page is displayed book "Learn Selenium: Build data-driven test frameworks for mobile and web applications with Selenium Web Driver 3"
     */

    @Test(priority = 20)
    public void searchInput() {
        driver.navigate().to("https://www.amazon.com/?ref_=nav_custrec_signin&captcha_verified=1&claim_type=EmailAddress&new_account=1&&");
        singIn();
        HomePageAmazon homePageAmazon = new HomePageAmazon(driver, webDriverWait);
        String inputBookName = "selenium testing";
        homePageAmazon.inputSearch(inputBookName);
        Assert.assertTrue(driver.findElement(By.linkText("Learn Selenium: Build data-driven test frameworks for mobile and web applications with Selenium Web Driver 3")).isDisplayed());
        System.out.println("Learn Selenium: Build data-driven test frameworks for mobile and web applications with Selenium Web Driver 3 is displeyed");
        System.out.println();

    }

    public void search(String imput) {
        HomePageAmazon homePageAmazon = new HomePageAmazon(driver, webDriverWait);
        homePageAmazon.inputSearch(imput);
    }
    /**
     * Test case 3: Add books to cart at www.amazon.com
     * 1.Open page www.amazon.com
     * 2.Click Sing in button
     * 3.Input username "salsita" into Username field
     * 4.Input password ITbootcamp@21 into Password field
     * 5.Click on SignIn button
     * 6.Asserted that the basket is empty.
     * 7.Input at searBar book name "selenium testing"
     * 8.Click on book "Learn Selenium: Build data-driven test frameworks for mobile and web applications with Selenium Web Driver 3"
     * 9.Open page  https://www.amazon.com/Learn-Selenium-data-driven-frameworks-applications/dp/183898304X/ref=sr_1_1?crid=2UNG8ULSNYU71&keywords=selenium+testing&qid=1644525284&sprefix=selenium+testing%2Caps%2C216&sr=8-1
     * 10. Click add to cart
     * 11. Asserted 1 book in basket "Learn Selenium: Build data-driven test frameworks for mobile and web applications with Selenium Web Driver 3"
     * 12. Go to searBar and type "the history of cuban music"
     * 13. Click on book2 "Roots in Reverse: Senegalese Afro-Cuban Music and Tropical Cosmopolitanism (Music / Culture)"
     * 14. Click add to cart book2
     * 15.Asserted 2 books in basket "Learn Selenium: Build data-driven test frameworks for mobile and web applications with Selenium Web Driver 3"
     * and "Roots in Reverse: Senegalese Afro-Cuban Music and Tropical Cosmopolitanism (Music / Culture)"
     */

    @Test(priority = 30)
    public void addBooksToCart() throws InterruptedException {

        driver.navigate().to("https://www.amazon.com/s?k=selenium+testing&dc&crid=25OVTWI1CF9F2&qid=1643762082&rnid=23598024011&sprefix=Sekenium+testin%2Caps%2C405&ref=sr_nr_p_n_free_shipping_afn_mfn_1");
        AddToCart addToCart = new AddToCart(driver, webDriverWait);

        String cartOn0 = driver.findElement(By.id("nav-cart-count")).getText();
        Assert.assertEquals(cartOn0, "0");
        System.out.println("Asserted that the basket is empty");
        addToCart.clickOn1Book();
        addToCart.clickAddToCartButton();
        String cartOn1 = driver.findElement(By.id("nav-cart-count")).getText();
        Assert.assertEquals(cartOn1, "1");
        System.out.println("Asserted 1 book in basket");
        String book2 = "the history of cuban music";
        search(book2);
        addToCart.clickOn2Book();
        addToCart.clickAddToCartButton();
        String cartOn2 = driver.findElement(By.id("nav-cart-count")).getText();
        org.testng.Assert.assertEquals(cartOn2, "2");
        System.out.println("Asserted 2 books in basket");
        addToCart.clickCart();
        String expectingURLCart = "https://www.amazon.com/gp/cart/view.html?ref_=nav_cart";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectingURLCart, actualURL);
        System.out.println("Assert current url https://www.amazon.com/gp/cart/view.html?ref_=nav_cart");


    }

    public void booksAdd() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com/s?k=selenium+testing&dc&crid=25OVTWI1CF9F2&qid=1643762082&rnid=23598024011&sprefix=Sekenium+testin%2Caps%2C405&ref=sr_nr_p_n_free_shipping_afn_mfn_1");
        AddToCart addToCart = new AddToCart(driver, webDriverWait);
        addToCart.clickOn1Book();
        addToCart.clickAddToCartButton();
        String book2 = "the history of cuban music";
        search(book2);
        addToCart.clickOn2Book();
        addToCart.clickAddToCartButton();
        addToCart.clickCart();
    }
    /** Test case 4: Remove book from cart
     * 1.Open page www.amazon.com
     * 2.Click Sing in button
     * 3.Input username "salsita" into Username field
     * 4.Input password ITbootcamp@21 into Password field
     * 5.Click on SignIn button
     * 6.Click on cart
     * 7.Click on button delete book ""Roots in Reverse: Senegalese Afro-Cuban Music and Tropical Cosmopolitanism (Music / Culture)"
     * 8.Asserted deleted 1 book from cart */

    @Test(priority = 40)
    public void deleteBookFromCart() throws InterruptedException {
        booksAdd();
        Cart cart = new Cart(driver, webDriverWait);
        cart.clickDeleteBook2();
        String cartCount = driver.findElement(By.id("nav-cart-count")).getText();
        Assert.assertEquals(cartCount, "1");
        System.out.println("Asserted deleted 1 book in basket");

    }

    public void book1Add2Times() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com/s?k=selenium+testing&dc&crid=25OVTWI1CF9F2&qid=1643762082&rnid=23598024011&sprefix=Sekenium+testin%2Caps%2C405&ref=sr_nr_p_n_free_shipping_afn_mfn_1");
        AddToCart addToCart = new AddToCart(driver, webDriverWait);
        Cart cart = new Cart(driver, webDriverWait);
        addToCart.clickOn1Book();
        addToCart.clickAddToCartButton();
        addToCart.clickCart();
        cart.clickDropDownButton();
        cart.clickDropdownSelectQuantity2();
    }
    // This Test isn't finish because Amazon has security on field credit cart information

    @Test(priority = 50)
    public void orderBooksWithInvalidCreditCart() throws InterruptedException {
        book1Add2Times();
        String glavniProzor = driver.getWindowHandle();
        ProceedToCheckOut proceedToCheckOut = new ProceedToCheckOut(driver, webDriverWait);
        CreateAccoutAmazon signIn = new CreateAccoutAmazon(driver, webDriverWait);
        SelectAShippingAddressAmazon shippingAddress = new SelectAShippingAddressAmazon(driver, webDriverWait);
        PaymentMethodAmazon paymentMethodAmazon = new PaymentMethodAmazon(driver, webDriverWait);

        proceedToCheckOut.clickProceedToCheckOutButton();
        String validEmail = "nekaproba21@gmail.com";
        String validPassword = "ITbootcamp@21000";
        signIn.inputEmail(validEmail);
        signIn.clickContinueButton();
        signIn.inputPassword(validPassword);
        signIn.clickSignInSubmitButtom();
        //--------Shipping Address_____
        Thread.sleep(2000);
        shippingAddress.clickOnDropDown();
        shippingAddress.clickSrbia();
        Thread.sleep(2000);
        String fullName = "Marta Martic";
        shippingAddress.inputFullName(fullName);
        String streetAddresss = "Kraljevica Marka";
        shippingAddress.inputStreet(streetAddresss);
        String apartmentNumFloor = "1, floor 5";
        shippingAddress.inputAppartmentNum(apartmentNumFloor);
        String city = "Novi Sad";
        shippingAddress.inputCity(city);
        String region = "Vojvodina";
        shippingAddress.inputRegion(region);
        String zipCode = "21000";
        shippingAddress.inputZipCode(zipCode);
        String phoneNumber = "0604046030";
        shippingAddress.inputPhoneNumber(phoneNumber);
        shippingAddress.clickUseThisAddressButton();
        String expectingURL = "https://www.amazon.com/gp/buy/addressselect/handlers/display.html?hasWorkingJavascript=1";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectingURL);
        System.out.println("Assert current URL is https://www.amazon.com/gp/yourstore?ie=UTF8&ref=ox_checkout_redirects_yourstore");
        //--------Add Credit Cart---
        Thread.sleep(5000);
        paymentMethodAmazon.clickAddCreditCart();
       /* Thread.sleep(5000);
        Set<String> x=driver.getWindowHandles();
        Iterator<String> i=x.iterator();
        driver.switchTo().window(i.next().toString());
        Thread.sleep(5000);*/
        System.out.println("Presao je na prozor");
        /*   *//* WebElement frame= driver.findElement(By.id("pp-b310D1-13"));

        driver.switchTo().frame(frame);*//*
         *//*paymentMethodAmazon.clickAddYourCart();
        String wrongCartNumber="5574 8900 0000 0000";
        paymentMethodAmazon.inputCartNumber(wrongCartNumber);
        String wrongNameOnCart="Petar Petrovic";
        paymentMethodAmazon.inputNameOnCart(wrongNameOnCart);
        paymentMethodAmazon.months();
        paymentMethodAmazon.year();*//*
        //paymentMethodAmazon.errorMessage();
        String errorMessage="There was a problem.";
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"pp-QvKznd-14\"]/div/div/div/h4")).isDisplayed(),errorMessage);
*/

    }

    public void tearDown() throws IOException {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");

    }
}

