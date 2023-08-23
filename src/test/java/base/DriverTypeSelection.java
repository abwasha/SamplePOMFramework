package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverTypeSelection {
    public static WebDriver driver;
    Properties properties = new Properties();

    public DriverTypeSelection() {
        try {
            FileInputStream inputStream = new FileInputStream("common.properties");
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public WebDriver SelectBrowserTypeAndPropertiesFromPropertiesFile() {
        String chrome = System.getenv("webdriver.chrome.driver");
        String mozilla = System.getenv("webdriver.gecko.driver");

        System.out.println("chrome Property 1: " + chrome);
        System.out.println("mozilla Property 2: " + mozilla);

        if (properties.getProperty("BROWSER").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("CHROME_EXECUTABLE_PATH"));
            System.out.println("CHROME_EXECUTABLE_PATH "+properties.getProperty("CHROME_EXECUTABLE_PATH"));
            driver = new ChromeDriver();
        } else if (properties.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("FIREFOX_EXECUTABLE_PATH"));
            System.out.println("FIREFOX_EXECUTABLE_PATH "+properties.getProperty("FIREFOX_EXECUTABLE_PATH"));
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser type: " + properties.getProperty("BROWSER"));
        }
        return driver;
    }
}
