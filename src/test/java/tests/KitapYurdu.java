package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.AllPages;
import utilities.Driver;


//https://www.swtestacademy.com/
@Epic("Regression Tests")
@Feature("Cart Tests")
public class KitapYurdu {


    @Description("Test Description: Scenario where the user adds and removes items from the cart.")
    @Story("Test to add product to cart")
    @Test(priority = 1, description = "Scenario where the user adds and removes items from the cart.")
    public void kitapYurduTest() {

        AllPages allPages = new AllPages();

        allPages.homePage().goToUrl("url");
        allPages.homePage().verifyTitle("Kitapyurdu, Kitapla buluşmanın en kolay yolu");
        allPages.homePage().cookiesAccept();
        allPages.homePage().searchProduct("roman");
        allPages.searchResultsPage().verifySearchResult("roman");
        allPages.searchResultsPage().clickPage("2");
        allPages.searchResultsPage().pageVerify("2");
        allPages.searchResultsPage().chooseRandomBook();
        allPages.productDetailsPage().verifySepetCount("0");
        allPages.productDetailsPage().sepeteEkleButton();
        allPages.productDetailsPage().verifySepetCount("1");
        allPages.productDetailsPage().sepeteGit();
        allPages.cartPage().changeSepetQuantity(1);
        allPages.cartPage().clickRefresh();
        allPages.cartPage().verifyUpdateCart("Sepetiniz güncelleniyor!");
        allPages.cartPage().removeCart();
        allPages.productDetailsPage().verifySepetCount("0");

        Driver.closeDriver();
    }
}
