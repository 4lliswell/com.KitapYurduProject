package pages;

import com.beust.ah.A;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;
import utilities.ReusableMethods;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static final Logger LOG = LogManager.getLogger(CartPage.class);

    @FindBy(xpath = "//input[@name='quantity']")
    WebElement sepetQuantity;

    @FindBy(xpath = "//i[@class='fa fa-refresh green-icon']")
    WebElement refreshButton;

    @FindBy(xpath = "//h2[@id='swal2-title']")
    WebElement popup;

    @FindBy(xpath = "//i[@title='Kaldır']")
    WebElement kaldirButton;


    @Step("User increased product quantity")
    public void changeSepetQuantity(int number) {

        String quantity = sepetQuantity.getAttribute("value");
        int q = Integer.parseInt(quantity);
        String sum = String.valueOf(q + number);

        sepetQuantity.clear();
        sepetQuantity.sendKeys(sum);
        LOG.info("User changed sepet quantity");
    }

    @Step("User clicked the refresh button")
    public void clickRefresh() {

        refreshButton.click();
        LOG.info("User click refresh button");
    }

    @Step("User confirms cart update")
    public void verifyUpdateCart(String expected) {

        ReusableMethods.waitForVisibility(popup, 5);
        Assert.assertEquals(expected, popup.getText());
        LOG.info("User verify cart update");
    }

    @Step("User deleted product from cart")
    public void removeCart() {

        kaldirButton.click();
        LOG.info("user deletes product from cart");
    }
}
