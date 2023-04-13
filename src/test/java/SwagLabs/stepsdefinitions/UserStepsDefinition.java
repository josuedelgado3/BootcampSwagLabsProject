package SwagLabs.stepsdefinitions;

import SwagLabs.steps.UserSwagLabs;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.Ensure;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

public class UserStepsDefinition {
    //page definitions
    @Steps(shared = true)
    UserSwagLabs user;

    @Given("^a standard user tries to login with valid credentials$")
    public void userLogins() throws InterruptedException {
        user.navigateTo();
        Serenity.takeScreenshot();
        user.attemptLogin("standard_user","secret_sauce");
    }

    @And("^the login is successful$")
    public void userLoginIsSuccessfulValidation(){
        user.validateLoginIsSuccessful();
    }

    @Then("^the user is redirected to the products page$")
    public void userIsRedirectedOnLoginValidation(){
        user.validateUserIsRedirectedOnLogin();
        Serenity.takeScreenshot();
    }

    @Given("^an authenticated user$")
    public void userIsAuthenticated(){
        user.validateLoginIsSuccessful();
    }

    @And("^user selects the tab 'about'$")
    public void userSelectsAboutTab(){
        user.selectAboutTab();
    }

    @Then("^user sees the about page$")
    public void validateUserIsOnAboutPage() throws InterruptedException {
        user.validateUserIsOnAboutPage();
        Thread.sleep(2000);
        Serenity.takeScreenshot();
    }

    @When("^user goes back to the previous page$")
    public void userSelectsToGoToPreviousPage() throws InterruptedException {
        user.goToPreviousPage();
        Thread.sleep(2000);
    }

    @Then("^user is redirected to the products page$")
    public void userIsRedirectedToPreviousPage(){
        user.validateUserIsRedirectedToPreviousPage();
        Serenity.takeScreenshot();
    }

    @When("^user selects the 'Price \\(high to Low\\)' filter$")
    public void userSelectsHighToLowFiltersForProducts() throws InterruptedException {
        user.selectFilterOnProductsGrid("Price (high to low)");
        Serenity.takeScreenshot();
    }

    @And("^user selects the four most expensive products \\(first 4 elements based on the filter\\)$")
    public void userSelectsFourMostExpensiveProducts() throws InterruptedException {
        user.selectNAmountOfProducts(4);
    }

    @Then("^user's cart amount is updated to 4$")
    public void userCartIsUpdated(){
        user.verifyAmountOfProductsOnCart(4);
        Serenity.takeScreenshot();
    }

    @When("^presses the cart icon$")
    public void userSelectsTheCartIcon(){
        user.selectCartIcon();
    }

    @Then("^the cart page with the selected products is shown$")
    public void userSeesSelectedProductsOnCartPage(){
        user.verifyCartPageIsVisible();
        Serenity.takeScreenshot();
    }

    @When("^user presses the checkout button$")
    public void userSelectsCheckoutButton(){
        user.selectCheckoutButton();
    }

    @Then("^the checkout information is shown$")
    public void userSeesCheckoutPersonalInformationForm(){
        user.verifyCheckoutFormIsDisplayed();
        Serenity.takeScreenshot();
    }

    @And("^user fills their 'first name', 'last name', and 'zip/postal code'$")
    public void userFillsPersonalInformation(){
        user.fillsCheckoutForm("John","Doe","123456");
        Serenity.takeScreenshot();
    }

    @And("^user presses the continue button$")
    public void userSelectsContinueButton(){
        user.selectCheckoutContinugeButton();
    }

    @Then("^the checkout overview page is shown with a summary of the purchase$")
    public void userSeesOverviewOnCheckout(){
        user.verifyCheckoutOverviewIsDisplayed();
        Serenity.takeScreenshot();
    }

    @And("^user validates the total price is as expected$")
    public void userValidatesTotalPriceInformation(){
        user.validatePurchaseInformationIsCorrect();
        Serenity.takeScreenshot();
    }

    @When("^user is sure that it's ok, they press finish$")
    public void userSelectsFinishButton(){
        user.selectCheckoutFinishButton();
    }

    @Then("^a page with the message 'Thank you for your order!' is shown$")
    public void userSeesSuccessfulPurchaseOrder(){
        user.verifySuccessMessageIsDisplayed();
        Serenity.takeScreenshot();
    }
}
