package pages;

import com.beust.ah.A;
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


    public void changeSepetQuantity(int number) {

        String quantity = getAttribute(sepetQuantity, "value");
        int q = Integer.parseInt(quantity);
        String sum = String.valueOf(q + number);

        sepetQuantity.clear();
        sepetQuantity.sendKeys(sum);
        LOG.info("User changed sepet quantity");
    }

    public void clickRefresh() {

        refreshButton.click();
        LOG.info("User click refresh button");
    }

    public void verifyUpdateCart(String expected) {

        ReusableMethods.waitForVisibility(popup,5);
        ReusableMethods.assertText(expected, popup.getText());
        LOG.info("User verify cart update");
    }

    public void removeCart(){

        kaldirButton.click();
        LOG.info("user deletes product from cart");

    }


    public String getAttribute(WebElement element, String attribute) {

        return element.getAttribute(attribute);
    }


}
