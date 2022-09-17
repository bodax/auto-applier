package com.bodax.home.newimpl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Class
 *
 * @author Bohdan Okun (markpolo525@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class Property {

    private Property() {
    }

    private static Properties properties;
    private static final String resourceFilePath = "src/main/resources/config.properties";
    //private static final String resourceFilePath = "config.properties";

    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                resourceFilePath), StandardCharsets.UTF_8))) {
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPathToDriver() {
        return properties.getProperty("driver");
    }

    public static String getChromePath() {
        return properties.getProperty("chrome");
    }

    public static String getLogin1() {
        return properties.getProperty("login1");
    }

    public static String getPass1() {
        return properties.getProperty("pass1");
    }

    public static String getLogin2() {
        return properties.getProperty("login2");
    }

    public static String getPass2() {
        return properties.getProperty("pass2");
    }

    public static String getLogin3() {
        return properties.getProperty("login3");
    }

    public static String getPass3() {
        return properties.getProperty("pass3");
    }

    public static String getLogin4() {
        return properties.getProperty("login4");
    }

    public static String getPass4() {
        return properties.getProperty("pass4");
    }

    public static String getLogin5() {
        return properties.getProperty("login5");
    }

    public static String getPass5() {
        return properties.getProperty("pass5");
    }


    public static String getComment1() {
        return properties.getProperty("comment1");
    }

    public static String getComment2() {
        return properties.getProperty("comment2");
    }

    public static String getComment3() {
        return properties.getProperty("comment3");
    }

    public static String getComment4() {
        return properties.getProperty("comment4");
    }

    public static String getComment5() {
        return properties.getProperty("comment5");
    }

}
