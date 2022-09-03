package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage  extends BaseClass{

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver, Duration.ofSeconds(30)), this);
    }


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Open navigation menu'`]")
    @AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Menu opened']")
    protected WebElement menuButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Lab Tests'`]")
    @AndroidFindBy(xpath="//*[@text='Lab Tests']")
    protected WebElement labTest;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Looking for...'`]")
    @AndroidFindBy(id="com.illionsoft.thyrocare:id/edtSearch")
    protected WebElement searchTextBox;

    @iOSXCUITFindBy(xpath = "//*[contains(@name,'HbA1c')]")
    protected WebElement bloodtestName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add To Cart\"]")
    @AndroidFindBy(id="com.illionsoft.thyrocare:id/togCart")
    protected WebElement cartButton;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Go To Cart\"`]")
    @AndroidFindBy(id="com.illionsoft.thyrocare:id/togCart")
    protected WebElement goToCart;

    //android.widget.TextView[@text='HbA1c']

    @AndroidFindBy(id="com.illionsoft.thyrocare:id/iv_home")
    protected WebElement homeButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeLink[`label == \"Skip now\"`]")
    protected WebElement skipButton;



    public void navigateToLabTest(){
        menuButton.click();
        labTest.click();
    }

    public void bookTest(String testName){
        searchTextBox.click();
        searchTextBox.sendKeys(testName);
        try {
            if (bloodtestName.isDisplayed())
                bloodtestName.click();
        }catch (Exception e) {

        }
        cartButton.click();
        try {
            if (goToCart.isDisplayed()) {
                goToCart.click();
                skipButton.click();
            }
        }catch (Exception e) {}
    }

    public void navigateToHomePage(){
        try{
            if(((AndroidDriver) driver).isKeyboardShown()) {
                ((AndroidDriver) driver).hideKeyboard();
            }
        homeButton.click();}
        catch (Exception e) {}
    }


}
