package SwagLabs.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "user-name")
    public WebElementFacade txtUsername;

    @FindBy(id = "password")
    public WebElementFacade txtPassword;

    @FindBy(id = "login-button")
    public WebElementFacade btnLogin;

    public void fillLoginForm(String username, String password){
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        btnLogin.click();
    }
}
