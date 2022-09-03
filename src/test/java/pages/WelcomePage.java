package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class WelcomePage extends BaseClass{
    public WelcomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver, Duration.ofSeconds(30)), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Allow'`]")
    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    protected WebElement permissionAllowWhileUsingApp;


    @AndroidFindBy(id="com.illionsoft.thyrocare:id/btn_next")
    protected WebElement nextButton;

    public void setPermission(){
        try {
            permissionAllowWhileUsingApp.click();
            if(nextButton.isDisplayed()) {
                for (int i = 0; i < 4; i++) {
                    nextButton.click();
                }
            }
        }catch (Exception e){
//            e.printStackTrace();
        }
    }




}
