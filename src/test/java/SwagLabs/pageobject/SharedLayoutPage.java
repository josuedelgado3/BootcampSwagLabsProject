package SwagLabs.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.FindBy;

public class SharedLayoutPage extends PageObject {
    @FindBy(id = "react-burger-menu-btn")
    WebElementFacade btnHamburguerMenu;

    @FindBy(id = "logout_sidebar_link")
    WebElementFacade navItemLogout;

    @FindBy(id = "about_sidebar_link")
    WebElementFacade navItemAbout;

    @FindBy(className = "shopping_cart_link")
    WebElementFacade btnIconCart;

    @FindBy(className = "shopping_cart_badge")
    WebElementFacade lblAmountOfProductsOnCart;
    public void clickOnAboutNavigationItem(){
        btnHamburguerMenu.click();
        navItemAbout.click();
    }

    public void clickOnBtnIconCart(){
        btnIconCart.click();
    }

    public void validateAmountOfProductsOnCart(Integer expectedAmountOfProducts){
        Assertions.assertThat(expectedAmountOfProducts).as("The amount of products does not match the expected amount").isEqualTo(expectedAmountOfProducts);
    }

    public void validateNavItemLogoutIsOnTheDom(){
        Assertions.assertThat(navItemLogout.isPresent()).as("The logout option is not on the dom, which means user is not authenticated").isTrue();
    }
}
