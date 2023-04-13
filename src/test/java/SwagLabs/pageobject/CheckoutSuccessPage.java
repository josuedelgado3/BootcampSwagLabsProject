package SwagLabs.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.FindBy;

public class CheckoutSuccessPage extends PageObject {
    @FindBy(className = "complete-header")
    WebElementFacade lblThankYouForYourOrder;

    @FindBy(id = "back-to-products")
    WebElementFacade btnBackHome;

    public void verifySuccessMessageIsDisplayed(){
        Assertions.assertThat(lblThankYouForYourOrder.isDisplayed()).as("Success message should have been displayed").isTrue();
    }

    public void selectBackHomeButton(){
        btnBackHome.click();
    }
}
