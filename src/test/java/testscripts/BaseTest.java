package testscripts;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest
{


    protected    WebDriver driver;
    //String udid = "00008101-001E05300C52001E";
    @BeforeClass
    @Parameters("udid")
    public void setup(String udid) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();

        if(udid.length()>20){
            cap.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 12 mini");
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
            cap.setCapability("automationName","XCUITest");
            cap.setCapability("udid",udid);
            cap.setCapability(IOSMobileCapabilityType.BUNDLE_ID,"com.illionsoft.thyrocare");
            cap.setCapability("newCommandTimeout","80000");
            cap.setCapability("launchTimeout","80000");
            driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);

        }else {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "DemoDevice");
            cap.setCapability("automationName", "UiAutomator2");
            cap.setCapability("udid", udid);
            cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.illionsoft.thyrocare");
            cap.setCapability("appWaitDuration", 50000);
            cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.illionsoft.thyrocare.activity.SplashActivity");
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }




}
