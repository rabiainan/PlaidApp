package com.qa.stepdef;

import com.qa.base.TestBase;
import io.cucumber.java.en.And;
public class BaseSteps extends TestBase {

    @And("I wait for a while")
    public void waitForAWhile() {
        waitFor3Seconds();
    }
}
