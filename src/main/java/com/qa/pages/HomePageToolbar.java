package com.qa.pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.appmanagement.ApplicationState;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomePageToolbar  extends HomePage{
    public static String getAppNameOnTheLeftTop() {
        return appName.getText();
    }

    // ***Returns the theme of the page as DARK or LIGHT  @return

    public static String themeDarkLight() {
        String isChecked = menuThemeIcon.getAttribute("checked").toString();
        return  isChecked.equalsIgnoreCase("true") ? "dark" :  "light";
    }

    public void clickMenuIcon (String iconName) {
        selectMenuItem(iconName);
    }

    public static void selectOptionMenuItem(String optionLabel){
        switch (optionLabel){
            case "Login to Designer News":
                optionSubMenuItem_DesignerNewsLogin.click();
                break;
            case "About":
                optionSubMenuItem_About.click();
                break;
            default:
                break;
        }
    }

    public static void selectFilter(String filterName){
        driver.findElement(By.xpath("//*[contains(@text, \'" + filterName+ "\')]")).click();
    }
    public static String isFilterSelected(String filterName){
        return driver.findElement(By.xpath("//*[contains(@text, \'" + filterName+ "\')]")).getAttribute("enabled");
    }

    public static boolean isApplicationCrashed(){
        ApplicationState lastState = getAppState();
        System.out.println(lastState);
        if(lastState == ApplicationState.RUNNING_IN_FOREGROUND && errorFrame.size() > 0){
            errorFrameCloseButton.click();
            return true;
        }
        else if (lastState == ApplicationState.NOT_RUNNING)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private static ApplicationState getAppState() {
        return driver.queryAppState("io.plaidapp");
    }

    public static List<MobileElement> getListOf(String listType) {
        List<MobileElement> list = new ArrayList<MobileElement>();
        switch(listType){
            case "ClickableElementsOnTheMenu":
                list.add(menuThemeIcon);
                list.add(filterIcon);
                list.add(moreOptionsIcon);
                list.add(searchIcon);
                break;
            case "FilterSection":
                list.add(filterSubMenuItem_PopularDesignerNews);
                list.add(filterSubMenuItem_MaterialDesign);
                list.add(filterSubMenuItem_ProductHunt);
                break;
        }
        return list;
    }

    public static void selectMenuItem(String menuItem) {
        switch (menuItem){
            case "Search":
                searchIcon.click();
                break;
            case "Theme":
                menuThemeIcon.click();
                break;
            case "Filter":
                filterIcon.click();
                break;
            case "MoreOptions":
                moreOptionsIcon.click();
                break;
        }
    }


}
