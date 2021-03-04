package com.qa.pages;

import com.qa.base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import java.util.List;

public class HomePage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView")
    protected static MobileElement appName;

    @AndroidFindBy(id = "io.plaidapp:id/menu_search")
    protected static MobileElement searchIcon;

    @AndroidFindBy(id = "io.plaidapp:id/menu_filter")
    protected static MobileElement filterIcon;

    @AndroidFindBy(id = "io.plaidapp:id/menu_theme")
    protected static MobileElement menuThemeIcon;

    @AndroidBy(id="io.plaidapp:id/" + "%s")
    protected static By menuIcons;

    @AndroidFindBy(accessibility = "More options")
    protected static MobileElement moreOptionsIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'About')]")
    protected static MobileElement optionSubMenuItem_About;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Log in')]")
    protected static MobileElement optionSubMenuItem_DesignerNewsLogin;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Popular Designer News')]")
    protected static MobileElement filterSubMenuItem_PopularDesignerNews;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Product Hunt')]")
    protected static MobileElement filterSubMenuItem_ProductHunt;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Material Design')]")
    protected static MobileElement filterSubMenuItem_MaterialDesign;

    @AndroidFindBy(id = "io.plaidapp:id/no_filters")
    protected static List<MobileElement> noFilterSelectedWarning;

    @AndroidFindBy(id = "android:id/aerr_close")
    protected static MobileElement errorFrameCloseButton;

    @AndroidFindBy(xpath = "//android.widget.button[contains(text(),'App info')]")
    protected static MobileElement errorFrameAppInfoButton;

    @AndroidFindBy(id = "android:id/alertTitle")
    protected static List<MobileElement> errorFrame;

    public static boolean isWarningVisible() {

        return noFilterSelectedWarning.size()  > 0 ? true : false;
    }

}
