package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ManageWaits;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {

    private WebDriver driver;
    private final By resultLinks= By.xpath("//div/article/descendant::h3/a");
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean searchResults(String userInputText){
        boolean result=false;
       List<WebElement> list=driver.findElements(resultLinks);
        for (WebElement element:list) {
            System.out.println(element.getText());
            if(element.getText().equals(userInputText)) {
                result=true;
                break;
            }
        }
        return result;
    }

}
