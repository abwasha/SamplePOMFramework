package base;

import com.google.common.io.Files;
import org.example.pages.HomePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.ManageWaits;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    public ManageWaits manageWaits;

    protected DriverTypeSelection driverTypeSelection= new DriverTypeSelection();

    @BeforeClass
    public void setUp() {
        driver = driverTypeSelection.SelectBrowserTypeAndPropertiesFromPropertiesFile();
        System.out.println("Browser initialized and opened");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        System.out.println("Set Up Done. Browser initialized and opened go to Homepage");
        goToHomePage();
        homePage = new HomePage(driver);
        manageWaits = new ManageWaits(driver);
    }

    @BeforeMethod
    public void goToHomePage()
    {
        driver.get("https://the-internet.herokuapp.com/");}

    @AfterMethod
    public void takeScreenShotOnFailures(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("C:\\Users\\Administrator\\Documents\\GitHub\\SamplePOMFramework\\src\\main\\resources\\screenshots\\"+result.getTestName()+".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();}
}
