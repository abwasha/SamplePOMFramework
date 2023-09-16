package base;

import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.ManageWaits;
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
        System.out.println("Set Up Done. Browser initialized and opened");
    }

    @BeforeMethod
    public void goToHomePage()
    {
        driver.get("https://www.hexacta.com/");
        homePage = new HomePage(driver);
        manageWaits = new ManageWaits(driver);

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
