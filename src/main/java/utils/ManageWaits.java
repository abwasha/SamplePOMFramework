package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ManageWaits {

    private WebDriver driver;

    public ManageWaits(WebDriver driver){
        this.driver=driver;
    }

    public void waitForElementToBeVisible(By element){
        WebDriverWait waits= new WebDriverWait(driver, Duration.ofSeconds(10));
        waits.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public boolean isElementPresent(By element){
        List<WebElement> listofElements= driver.findElements(element);
        if(listofElements.size() > 0) {
            return true;
        } else
            return false;
    }
 }
