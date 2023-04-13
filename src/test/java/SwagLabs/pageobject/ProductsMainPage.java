package SwagLabs.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsMainPage extends PageObject {
    @FindBy(className = "product_sort_container")
    WebElementFacade cboxProductFilter;

//    @FindBy(css = ".product_sort_container option")
//    List<WebElementFacade> cboxProductFilterOptions;

    @FindBy(className = "inventory_item")
    List<WebElementFacade> productItems;

    @FindBy(id="inventory_container")
    WebElementFacade productsGridContainer;

    public void selectFilter(String filterName) throws InterruptedException {
        cboxProductFilter.selectByVisibleText(filterName);
    }

    public void addFirstNItemsToCart(Integer numberOfItems) throws InterruptedException{
        Integer itemCount = 1;
        for (WebElementFacade productItem : productItems){
            if (itemCount > numberOfItems) break;
            WebElementFacade btnAddToCart = productItem.findBy(By.tagName("button"));
            btnAddToCart.click();
            itemCount += 1;
        }
    }

    public void validateProductGridOnTheScreen(){
        Assertions.assertThat(productsGridContainer.isPresent()).as("The user was not redirected to main page on login").isTrue();
    }


}
