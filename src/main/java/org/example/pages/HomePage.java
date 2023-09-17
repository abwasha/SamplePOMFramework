package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.ManageWaits;

public class HomePage {
    private WebDriver driver;
    public By contactUsElement = By.className("contactus");
    public By searchBox = By.xpath("//a[@class='searchbox']");
    public By searchInputTextBox = By.xpath("//input[@name='s']");
    public By searchResultHeader = By.xpath("//div/h1[@class='search-title']");
    public By contextMenuLink = By.partialLinkText("Context Menu");
    public HomePage(WebDriver driver) {

        this.driver = driver;
    }
    public ContactUsPage clickContactUs(){
           driver.findElement(contactUsElement).click();
           return new ContactUsPage(driver);
    }

    public SearchResultPage enterTextInSearchBar(String userText){
        manageWaits.waitForElementToBeVisible(searchBox);
        driver.findElement(searchBox).click();
        driver.findElement(searchInputTextBox).click();
        driver.findElement(searchInputTextBox).sendKeys(userText);
        driver.findElement(searchInputTextBox).sendKeys(Keys.ENTER);
        manageWaits.waitForElementToBeVisible(searchResultHeader);
        return new SearchResultPage(driver);
    }
   protected ManageWaits manageWaits= new ManageWaits(driver);

    public ConfirmationPage confirmationPage(){
        return  new ConfirmationPage(driver);
    }
    public void practiseMethod(){

        driver.findElement(searchInputTextBox).sendKeys(Keys.chord(Keys.CONTROL,"a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(searchBox)).click().build().perform();
    }

    public ModalPage clickModalLink(){
        driver.findElement(contextMenuLink).click();
        return new ModalPage(driver);
    }
}