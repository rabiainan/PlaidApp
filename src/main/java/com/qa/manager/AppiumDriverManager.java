package com.qa.manager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import com.qa.utils.TestUtils;

public class AppiumDriverManager implements DriverManager{
    @Override
    public AndroidDriver createDriver()  {
        TestUtils utils = new TestUtils();
        Properties props = utils.getAppPropertiesFile();
        URL urlInconfigFile = null;
        try {
            urlInconfigFile = new URL(props.getProperty("url"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String platform = props.getProperty("platformName");
        String device = props.getProperty("deviceName");
        String version=props.getProperty("platformVersion");


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
        caps.setCapability(MobileCapabilityType.VERSION, version);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
        caps.setCapability("appPackage", "io.plaidapp");
        caps.setCapability("appActivity", "io.plaidapp.ui.HomeActivity");
        return new AndroidDriver<MobileElement>(urlInconfigFile, caps);
    }

}
