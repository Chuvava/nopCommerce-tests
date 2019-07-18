package nopcommerce;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private String browser;
    private String baseUrl;
    private String username;
    private String password;

    public Configuration() throws IOException {

        String root = new File("").getAbsolutePath();

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(root + "//src//main//java//nopcommerce//properties//data.properties");
        prop.load(fis);

        this.browser = prop.getProperty("browser");
        this.baseUrl = prop.getProperty("baseUrl");
        this.username = prop.getProperty("username");
        this.password = prop.getProperty("password");
    }

    public String getBrowser() {
        return browser;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
