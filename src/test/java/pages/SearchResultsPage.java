package pages;

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

    public void verifySearchResult(String product) {

        ReusableMethods.assertText(product, resultTitle.getText());
        LOG.info("User verify result " + product);
    }

    public void clickPage(String pageNumber){

        WebElement secondPage = Driver.getDriver().findElement(By.linkText(pageNumber));
        ReusableMethods.clickElementByJS(secondPage);
        LOG.info("user switches to second page");
    }

    public void chooseRandomBook() {
        Random random = new Random();
        int aa = random.nextInt(searchBookLists.size());

        searchBookLists.get(aa).click();
        LOG.info("user adds a random product to cart");
    }

    public void pageVerify(String urlPageNumber){

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(urlPageNumber));
        LOG.info("user confirms that it is on the second page");
    }


}
