package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ManageWaits;

public class ConfirmationPage {
    private WebDriver driver;
    public final By confirmationTextElement= By.name("confirm_message");
    public ConfirmationPage(WebDriver driver) {
        this.driver=driver;
    }

    public ConfirmationPage confirmationPage(){
        return  new ConfirmationPage(driver);
    }

    public String getConfirmationText(){
        return driver.findElement (confirmationTextElement).getText();
    }

}
