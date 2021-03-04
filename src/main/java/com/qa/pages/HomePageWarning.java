package com.qa.pages;

public class HomePageWarning extends HomePage{

    public static boolean isWarningVisible() {
        return noFilterSelectedWarning.size()  > 0 ? true : false;
    }
}
