package com.qa.base;
import com.qa.pages.HomePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public  static AppiumDriver<MobileElement> driver;
    public static WebDriverWait wait;

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static HomePage openApp(){
        return new HomePage();
    }

    public static void clickButtonOnPhone(String buttonName) {
        switch (buttonName) {
            case "back":
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        }
    }

}
