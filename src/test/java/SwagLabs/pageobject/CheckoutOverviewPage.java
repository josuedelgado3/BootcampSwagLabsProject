package SwagLabs.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends PageObject {
    @FindBy(css = ".summary_info :nth-child(2)")
    WebElementFacade lblPaymentInformation;
    @FindBy(css = ".summary_info :nth-child(4)")
    WebElementFacade lblShippingInformation;
    @FindBy(className = "summary_subtotal_label")
    WebElementFacade lblSubtotalPrice;
    @FindBy(className = "summary_tax_label")
    WebElementFacade lblTaxPrice;
    @FindBy(className = "summary_total_label")
    WebElementFacade lblTotalPrice;
    @FindBy(id="finish")
    WebElementFacade btnFinish;
    @FindBy(className = "checkout_summary_container")
    WebElementFacade checkoutSummaryWrapper;

    public void verifyPriceTotalIsCorrectlyCalculated(){
        Double subtotalPrice = Double.parseDouble(lblSubtotalPrice.getText().split("\\$")[1]);
        Double taxPrice = Double.parseDouble(lblTaxPrice.getText().split("\\$")[1]);
        System.out.println("subtotal " + subtotalPrice);
        System.out.println("total: " + taxPrice);
        // our manual calculation
        Double calculatedTotal = Math.round((subtotalPrice + taxPrice)*100.0)/100.0;
        // website calculation
        Double websiteCalculation = Math.round((Double.parseDouble(lblTotalPrice.getText().split("\\$")[1]))*100.0)/100.0;
        Assertions.assertThat(calculatedTotal).as("The total price does not match the addition of subtotal + tax price.").isEqualTo(websiteCalculation);
    }

    public void clickOnFinishButton(){
        btnFinish.click();
    }

    public void verifyOverviewWrapperIsDisplayed(){
        Assertions.assertThat(checkoutSummaryWrapper.isDisplayed()).as("The overview page should be displayed").isTrue();
    }

    public void generateOverviewReport(){
        String concatenatedData = "";
        concatenatedData = concatenatedData + "The payment information is: " + lblPaymentInformation.getText() + "\n";
        concatenatedData = concatenatedData + "The shipping information is: " + lblShippingInformation.getText() + "\n";
        concatenatedData = concatenatedData + "The subtotal price is: " + lblSubtotalPrice.getText() + "\n";
        concatenatedData = concatenatedData + "The tax price is: " + lblTaxPrice.getText() + "\n";
        concatenatedData = concatenatedData + "The total price is: " + lblTotalPrice.getText() + ".";
        Serenity.recordReportData().withTitle("Cart Overview data").andContents(concatenatedData);
    }

}
