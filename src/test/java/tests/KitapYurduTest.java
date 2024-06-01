package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.AllPages;
import pages.HomePage;
import pages.SearchResultsPage;


//https://www.swtestacademy.com/

public class KitapYurduTest {

    @Epic("Regression Tests")
    @Feature("Login Tests")
    @Test(priority = 1, description = "Login Scenario with  username and password.")
    public void test() {

        AllPages allPages = new AllPages();

        allPages.homePage().goToUrl("url");

        allPages.homePage().verifyTitle("Kitapyurdu, Kitapla buluşmanın en kolay yolu");

        allPages.homePage().cookiesAccept();

        allPages.homePage().searchProduct("roman");

        allPages.searchResultsPage().verifySearchResult("roman");

        allPages.searchResultsPage().clickPage("2");

        allPages.searchResultsPage().pageVerify("page=2");

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
    }
}
