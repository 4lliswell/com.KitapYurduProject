package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Random;

public class SearchResultsPage {

    public SearchResultsPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static final Logger LOG = LogManager.getLogger(SearchResultsPage.class);

    @FindBy(xpath = "//h1[@class='search-heading-title']//span[2]")
    WebElement resultTitle;

    @FindBy(xpath = "//div[@class='name']")
    List<WebElement> searchBookLists;

    @Step("User verify result")
    public void verifySearchResult(String product) {

        Assert.assertEquals(product, resultTitle.getText());
        LOG.info("User verify result " + product);
    }

    @Step("User switches to new page")
    public void clickPage(String pageNumber) {

        WebElement page = Driver.getDriver().findElement(By.linkText(pageNumber));
        ReusableMethods.clickElementByJS(page);
        LOG.info("User switches to new page");
    }

    @Step("User verify that he is on the new page")
    public void pageVerify(String urlPageNumber) {

        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(urlPageNumber));
        LOG.info("User verify that he is on the new page");
    }

    @Step("User adds a random product to cart")
    public void chooseRandomBook() {
        Random random = new Random();
        int number = random.nextInt(searchBookLists.size());

        searchBookLists.get(number).click();
        LOG.info("User adds a random product to cart");
    }


}
