package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class ProductDetailsPage {

    public ProductDetailsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static final Logger LOG = LogManager.getLogger(ProductDetailsPage.class);


    @FindBy(id = "button-cart")
    WebElement sepeteEkle;

    @FindBy(xpath = "//span[@id='cart-items']")
    WebElement sepetTextCount;

    @FindBy(id = "js-cart")
    WebElement sepeteGitButton;


    @Step("User adds the product to the cart")
    public void sepeteEkleButton() {

        ReusableMethods.waitForVisibility(sepeteEkle, 5);
        sepeteEkle.click();
        LOG.info("User adds the product to the cart");
    }

    @Step("User verifies the number of items in the cart")
    public void verifySepetCount(String count) {

        By sepet = By.id("cart-items");
        ReusableMethods.waitForTextToBe(sepet, count, 5);
        Assert.assertEquals(count, sepetTextCount.getText());
        LOG.info("User verifies the number of items in the cart");
    }

    @Step("User goes to cart")
    public void sepeteGit() {

        sepetTextCount.click();
        sepeteGitButton.click();
        LOG.info("User goes to cart");
    }
}


