package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ManageWaits;

import java.time.Duration;

public class ContactUsPage {

    private WebDriver driver;
    public  final By firstnameElement= By.name("firstname");
    private final By lastnameElement= By.name("lastname");
    private final By emailElement= By.name("email");
    private final By companyElement= By.name("company//name");
    public final By submitButton= By.xpath("//div/input[@value='Send']");

    public final By captchaFrameId= By.xpath("//iframe[starts-with(@title,'reCAPTCHA') and starts-with(@src,'https://www.google.com/recaptcha')]");
    public final By captchaButton= By.id("recaptcha-anchor");
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }
    public ConfirmationPage enterContactFormDetailsAndSubmit(String FName, String LName, String Email, String Company){
        driver.findElement(firstnameElement).sendKeys(FName);
        driver.findElement(lastnameElement).sendKeys(LName);
        driver.findElement(emailElement).sendKeys(Email);
        driver.findElement(companyElement).sendKeys(Company);
        waitForReCaptchaAndClick(captchaFrameId,captchaButton,submitButton);
        //driver.findElement(submitButton).click();
        return new ConfirmationPage(driver);
    }

    public void waitForReCaptchaAndClick(By frameElement,By buttonElement,By submitElement){
        WebDriverWait waits= new WebDriverWait(driver, Duration.ofSeconds(10));
        waits.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
        waits.until(ExpectedConditions.elementToBeClickable(buttonElement)).click();
        waits.until(ExpectedConditions.elementToBeClickable(submitElement)).click();
    }
}
