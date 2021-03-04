package com.qa.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.manager.AppiumDriverManager;
import com.qa.base.TestBase;
import java.io.IOException;

public class Hooks extends TestBase {

    @Before
    public void setup(Scenario scenario) throws IOException {
        AppiumDriverManager appiumDriverManager = new AppiumDriverManager();
        driver = appiumDriverManager.createDriver();
        wait = new WebDriverWait(driver, 10);
        startRecording();
    }

    @After
    public void tierDown(Scenario scenario) {
        stopRecording(scenario.getName() + "_" + scenario.getLine() +"_" + scenario.getStatus());
    }
}

