package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;
import java.util.stream.Collectors;

public class ModalPage {

    private WebDriver driver;

    private By box= By.id("hot-spot");
    public ModalPage(WebDriver driver){
        this.driver=driver;
    }
    public void rightClickOnBox(){
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(box)).perform();
    }
    public String readAlertText(){
        return driver.switchTo().alert().getText();    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void printHandles(){
        Set handles=driver.getWindowHandles();
        System.out.println("Handles Size "+handles.size());
        handles.stream().forEach(p -> System.out.println(p));
    }


}
