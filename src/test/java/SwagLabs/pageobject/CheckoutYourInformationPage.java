package SwagLabs.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInformationPage extends PageObject {

    @FindBy(id = "first-name")
    WebElementFacade txtFirstName;

    @FindBy(id="last-name")
    WebElementFacade txtLastName;

    @FindBy(id="postal-code")
    WebElementFacade txtPostalCode;

    @FindBy(id="continue")
    WebElementFacade btnContinue;

    @FindBy(className = "checkout_info_wrapper")
    WebElementFacade checkoutWrapper;

    public void fillFormInformation(String firstName, String lastName, String postalCode){
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtPostalCode.sendKeys(postalCode);
    }

    public void clickOnContinueButton(){
        btnContinue.click();
    }

    public void verifyCheckoutWrapperIsDisplayed(){
        Assertions.assertThat(checkoutWrapper.isDisplayed()).as("The form checkout personal information should be showed").isTrue();
    }

}
