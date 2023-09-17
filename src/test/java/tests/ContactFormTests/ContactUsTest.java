package tests.ContactFormTests;

import base.BaseTest;
import org.example.pages.ConfirmationPage;
import org.example.pages.ContactUsPage;
import org.testng.Assert;
import org.testng.annotations.*;


public class ContactUsTest extends BaseTest {

    @Test(enabled = false)
    public void testContactUsSubmissionForm()  {
    var contactUsPage= homePage.clickContactUs();
    manageWaits.waitForElementToBeVisible(contactUsPage.firstnameElement);
    var confirmationPage=contactUsPage.enterContactFormDetailsAndSubmit("A","b","C@C.COM","D");
    manageWaits.waitForElementToBeVisible(confirmationPage.confirmationTextElement);
    Assert.assertEquals(confirmationPage.getConfirmationText(),"Expected String");

    }
}