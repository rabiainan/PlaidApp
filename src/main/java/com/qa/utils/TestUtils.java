package com.qa.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {
    public static Properties getAppPropertiesFile() {
        Properties propts = null;
        try {
            File fileConfig = new File("src/main/resources/config.properties");
            FileInputStream stream = new FileInputStream(fileConfig);
            propts = new Properties();
            propts.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propts;
    }

}

