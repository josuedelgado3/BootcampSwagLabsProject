package SwagLabs.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends PageObject {
    @FindBy(className = "cart_item")
    List<WebElementFacade> cartItems;

    @FindBy(id = "checkout")
    WebElementFacade btnCheckout;

    @FindBy(css = ".header_secondary_container .title")
    WebElementFacade cartPageTitle;

    public void clickOnCheckoutButton(){
        btnCheckout.click();
    }

    public void verifyCartPageIsVisible(){
        Assertions.assertThat(cartPageTitle.isDisplayed()).as("Cart page is not displayed").isTrue();
    }

    public void generateCartDetailsReport(){
        String concatenatedData = "";
        for (WebElementFacade cartItem : cartItems){
            String productName = cartItem.findBy(".inventory_item_name").getText();
            String productQuantity = cartItem.findBy(".cart_quantity").getText();
            String productPrice = cartItem.findBy(".inventory_item_price").getText();
            String recordToAdd = "" + productName + " was ordered with a quantity of " + productQuantity + " adding a total price of " + productPrice + ".";
            concatenatedData = concatenatedData + recordToAdd + "\n";
        }
        Serenity.recordReportData().withTitle("Cart Content").andContents(concatenatedData);
    }

}
