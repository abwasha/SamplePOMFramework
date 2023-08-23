package tests.ContactFormTests;

import base.BaseTest;
import org.example.pages.SearchResultPage;


import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTextTest extends BaseTest {

    @Test(enabled = true)
    public void testSearchText()  {
        /*
        SearchResultPage searchResultPage=homePage.enterTextInSearchBar("outsource");
        String userInputText="SUCCESSFUL COMPANIES THAT OUTSOURCED SOME OF THEIR DEVELOPMENT";
        Assert.assertTrue(searchResultPage.searchResults(userInputText), "#"+userInputText+"# -->text is not preset");

         */
        String chrome = System.getenv("webdriver.chrome.driver");
        String mozilla = System.getenv("webdriver.gecko.driver");

        System.out.println("chrome Property 1: " + chrome);
        System.out.println("mozilla Property 2: " + mozilla);
    }
}
