package tests.ContactFormTests;

import base.BaseTest;
import org.example.pages.SearchResultPage;


import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTextTest extends BaseTest {

    @Test(enabled = false)
    public void testSearchText()  {

        var searchResultPage=homePage.enterTextInSearchBar("outsource");
        String userInputText="SUCCESSFUL COMPANIES THAT OUTSOURCED SOME OF THEIR DEVELOPMENT";
        Assert.assertTrue(searchResultPage.searchResults(userInputText), "#"+userInputText+"# -->text is not preset");

        System.out.println("Merge branch comment original retained and merged to main");
    }
}
