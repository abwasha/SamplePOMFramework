package utils;

import org.openqa.selenium.WebDriver;

public class BrowserWindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public BrowserWindowManager(WebDriver driver){
        this.driver=driver;
        navigate =driver.navigate();
    }
    public void goBack(){
        navigate.back();
    }
}
