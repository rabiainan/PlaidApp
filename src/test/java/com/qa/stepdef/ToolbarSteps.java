package com.qa.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.qa.base.BasePage;
import com.qa.pages.HomePage;
import com.qa.pages.HomePageToolbar;
import com.qa.pages.HomePageWarning;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import java.util.List;


public class ToolbarSteps {

    @Given("I opened the app successfully")
    public void iOpenedTheAppSuccessfully() {

        HomePage.openApp();
    }

    @Then("I should see {int} action icons on the toolbar")
    public void iShouldSeeActionIconsOnTheToolbar(Integer iconCount) {
       List<MobileElement> iconList = HomePageToolbar.getListOf("ClickableElementsOnTheMenu");
       Assert.assertTrue("It seems like there is a change, check the toolbar",  iconList.size()==iconCount);
    }

    @Then("app name should be {string}")
    public void appNameShouldBe(String appName) {

        Assert.assertEquals(appName, HomePageToolbar.getAppNameOnTheLeftTop());
    }

    @When("I click toolbar icon {string}")
    public void iClickToolbarIcon(String iconName) {

       HomePageToolbar.selectMenuItem(iconName);

    }
    @Then("the page theme should become {string}")
    public void thePageThemeShouldBecome(String theme) {

        String darkLight = HomePageToolbar.themeDarkLight();
        switch (theme) {
            case "dark theme":
                Assert.assertEquals("This is wrong theme, make sure that you clicked the theme icon Expected DARK", "dark", darkLight);
                break;
            case "light theme":
                Assert.assertEquals("This is wrong theme, make sure that you clicked the theme icon Expected LIGHT", "light", darkLight);
                break;
        }
    }

    @Then("Toolbar icon {string} should be working properly")
    public void toolbarIconShouldBeWorkingProperly(String menuItem) {

       HomePageToolbar.selectMenuItem(menuItem);
        applicationCrashCheck();
    }

    @Then("I should see {string} as selected")
    public void iShouldSeeAsSelected(String filter) {
        String filterSelected =HomePageToolbar.isFilterSelected(filter);
        Assert.assertTrue("Specified filter should be selected", filterSelected.equalsIgnoreCase("true"));
    }

    @Given("I unselect all the selected items")
    public void unselectAllTheFilters() {
        List<MobileElement> iconList = HomePageToolbar.getListOf("FilterSection");
        for (MobileElement icon : iconList) {
            if (icon.getAttribute("enabled").equalsIgnoreCase("true")) {
                icon.click();
            }
        }
    }

    @Given("I unselected all the selected filters")
    public void iUnselectedAllTheSelectedFilters() {
        iClickToolbarIcon("Filter");
        unselectAllTheFilters();
    }
    @Given("I selects {string}")
    public void iSelects(String filterName) {

        HomePageToolbar.selectFilter(filterName);
    }

    @Then("I should see results on the home screen")
    public void iShouldSeeResultsOnTheWelcomeScreen() {
        HomePage.clickButtonOnPhone("back");

        Assert.assertEquals("Results are not coming for the filter. Please check if the data to understand if this is the expected behaviour",
                HomePage.isWarningVisible(), false);
    }

    @Then("I should see no filter selected warning")
    public void iShouldSeeNoFilterSelectedWarning() {
        HomePage.clickButtonOnPhone("back");
        Assert.assertEquals(HomePageWarning.isWarningVisible(), true);
    }

    @When("I click option {string}")
    public void iClickOption(String optionLabel) {

        HomePageToolbar.selectOptionMenuItem(optionLabel);
    }

    @Then("The application should navigate to proper page")
    public void applicationCrashCheck(){
        Assert.assertFalse("The application is crashed! Page should navigate to the proper page instead.", HomePageToolbar.isApplicationCrashed());

    }

}
