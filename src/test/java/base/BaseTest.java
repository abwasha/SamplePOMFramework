package base;

import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.BrowserWindowManager;
import utils.ManageWaits;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp() {
        System.setProperty("web-driver.chrome.driver","C:\\Users\\Administrator\\Documents\\GitHub\\SampleFramework\\src\\main\\resources\\chromedriver.exe");
        System.setProperty("web-driver.firefox.driver","C:\\Users\\Administrator\\Documents\\GitHub\\SampleFramework\\src\\main\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();

        System.out.println("Set Up Done. Browser initialized and opened");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }

    @BeforeMethod
    public void goToHomePage()
    {
        driver.get("https://www.hexacta.com/");
        homePage = new HomePage(driver);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public BrowserWindowManager getWindowManager(){
        return  new BrowserWindowManager(driver);
    }
    public ManageWaits manageWaits(){
        return  new ManageWaits(driver);
    }

}
