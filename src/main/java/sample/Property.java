package sample;

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

    private static Properties properties;
     private static final String resourceFilePath = "src/main/resources/dev1.properties";
  //  private static final String resourceFilePath = "config.properties";

    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                resourceFilePath), StandardCharsets.UTF_8))) {
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPathToDriver() {
        return properties.getProperty("directory");
    }

    public String getLogin1() {
        return properties.getProperty("login1");
    }

    public String getPass1() {
        return properties.getProperty("pass1");
    }

    public String getLogin2() { return properties.getProperty("login2"); }

    public String getPass2() {
        return properties.getProperty("pass2");
    }

    public String getLogin3() {
        return properties.getProperty("login3");
    }

    public String getPass3() {
        return properties.getProperty("pass3");
    }

    public String getLogin4() {
        return properties.getProperty("login4");
    }

    public String getPass4() {
        return properties.getProperty("pass4");
    }

    public String getLogin5() {
        return properties.getProperty("login5");
    }

    public String getPass5() {
        return properties.getProperty("pass5");
    }


    public String getComment1() {
        return properties.getProperty("comment1");
    }

    public String getComment2() {
        return properties.getProperty("comment2");
    }

    public String getComment3() {
        return properties.getProperty("comment3");
    }

    public String getComment4() {
        return properties.getProperty("comment4");
    }

    public String getComment5() {
        return properties.getProperty("comment5");
    }
}
