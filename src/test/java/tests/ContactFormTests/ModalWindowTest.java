package tests.ContactFormTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModalWindowTest extends BaseTest {

    @Test

    public void testModelWindowText(){
        var modalWindow=homePage.clickModalLink();
        /*modalWindow.rightClickOnBox();
        var resultText=modalWindow.readAlertText();
        System.out.println("resultText--"+resultText);
        Assert.assertEquals(resultText,"You selected a context menu");
        modalWindow.acceptAlert();*/
        modalWindow.printHandles();
    }
}
