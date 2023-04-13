package SwagLabs.steps;

import SwagLabs.pageobject.*;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.ScenarioActor;

public class UserSwagLabs extends ScenarioActor {
    String actor;
    final String MAIN_PAGE_URL = "https://www.saucedemo.com/";

//    @Steps(shared = true)
    SharedLayoutPage objSharedLayoutPage;
    LoginPage objLoginPage;
    ProductsMainPage objProductsMainPage;
    AboutPage objAboutPage;
    CartPage objCartPage;
    CheckoutYourInformationPage objCheckoutPage;
    CheckoutOverviewPage objCheckoutOverviewPage;
    CheckoutSuccessPage objCheckoutSuccessPage;
    public void navigateTo(){
        objLoginPage.setDefaultBaseUrl(MAIN_PAGE_URL);
        objLoginPage.open();
    }
    public void validateLoginIsSuccessful(){
        objSharedLayoutPage.validateNavItemLogoutIsOnTheDom();
    }
    public void validateUserIsRedirectedOnLogin(){
        //verify we are now at main products page
        objProductsMainPage.validateProductGridOnTheScreen();
    }
    public void selectAboutTab(){
        objSharedLayoutPage.clickOnAboutNavigationItem();
    }
    public void validateUserIsOnAboutPage(){
        objAboutPage.isAboutPageUrlShown();
    }
    public void goToPreviousPage(){
        objSharedLayoutPage.getDriver().navigate().back();
    }
    public void validateUserIsRedirectedToPreviousPage(){
        objProductsMainPage.validateProductGridOnTheScreen();
    }
    public void selectFilterOnProductsGrid(String filterName) throws InterruptedException {
        objProductsMainPage.selectFilter(filterName);
    }
    public void selectNAmountOfProducts(Integer amountOfProducts) throws InterruptedException {
        objProductsMainPage.addFirstNItemsToCart(amountOfProducts);
    }
    public void verifyAmountOfProductsOnCart(Integer expectedAmount){
        objSharedLayoutPage.validateAmountOfProductsOnCart(expectedAmount);
    }
    public void selectCartIcon(){
        objSharedLayoutPage.clickOnBtnIconCart();
    }
    public void verifyCartPageIsVisible(){
        objCartPage.verifyCartPageIsVisible();
        objCartPage.generateCartDetailsReport();
    }

    public void selectCheckoutButton(){
        objCartPage.clickOnCheckoutButton();
    }

    public void verifyCheckoutFormIsDisplayed(){
        objCheckoutPage.verifyCheckoutWrapperIsDisplayed();
    }

    public void fillsCheckoutForm(String firstName, String lastName, String postalCode){
        objCheckoutPage.fillFormInformation(firstName,lastName,postalCode);
    }

    public void selectCheckoutContinugeButton(){
        objCheckoutPage.clickOnContinueButton();
    }

    public void verifyCheckoutOverviewIsDisplayed(){
        objCheckoutOverviewPage.verifyOverviewWrapperIsDisplayed();
    }

    public void validatePurchaseInformationIsCorrect(){
        objCheckoutOverviewPage.verifyPriceTotalIsCorrectlyCalculated();
        objCheckoutOverviewPage.generateOverviewReport();
    }

    public void selectCheckoutFinishButton(){
        objCheckoutOverviewPage.clickOnFinishButton();
    }

    public void verifySuccessMessageIsDisplayed(){
        objCheckoutSuccessPage.verifySuccessMessageIsDisplayed();
    }
    public void attemptLogin(String username, String password){
        objLoginPage.fillLoginForm(username,password);
        Serenity.takeScreenshot();
        objLoginPage.clickLoginButton();
    }
}
