package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.BrowserWindowManager;
import utils.ManageWaits;

public class HomePage {
    private WebDriver driver;
    public final By contactUsElement = By.className("contactus");
    public final By searchBox = By.xpath("//a[@class='searchbox']");
    public final By searchInputTextBox = By.xpath("//input[@name='s']");
    public final By searchResultHeader = By.xpath("//div/h1[@class='search-title']");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public ContactUsPage clickContactUs(){
           driver.findElement(contactUsElement).click();
           return new ContactUsPage(driver);
    }

    public SearchResultPage enterTextInSearchBar(String userText){
        manageWaits().waitForElementToBeVisible(searchBox);
        driver.findElement(searchBox).click();
        driver.findElement(searchInputTextBox).click();
        driver.findElement(searchInputTextBox).sendKeys(userText);
        driver.findElement(searchInputTextBox).sendKeys(Keys.ENTER);
        manageWaits().waitForElementToBeVisible(searchResultHeader);
        return new SearchResultPage(driver);
    }

    public ManageWaits manageWaits(){return new ManageWaits(driver);}

    public BrowserWindowManager browserWindowManager(){return new BrowserWindowManager(driver);}
    public ConfirmationPage confirmationPage(){
        return  new ConfirmationPage(driver);
    }
}