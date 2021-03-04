package com.qa.manager;
import com.qa.utils.TestUtils;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class iOSDriverManager implements DriverManager {

    @Override
    public MobileDriver createDriver() {
        TestUtils utils = new TestUtils();
        Properties props = utils.getAppPropertiesFile();
        URL urlInconfigFile = null;
        try {
            urlInconfigFile = new URL(props.getProperty("url"));
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
        String platform = props.getProperty("platformName");
        String device = props.getProperty("deviceName");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
        caps.setCapability(MobileCapabilityType.APP, props.getProperty("iOSApp"));
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        return new IOSDriver<MobileElement>(urlInconfigFile, caps);

    }











}
