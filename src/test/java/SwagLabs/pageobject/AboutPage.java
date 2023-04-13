package SwagLabs.pageobject;

import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.Assertions;

public class AboutPage extends PageObject {
    final String ABOUT_PAGE_URL ="https://saucelabs.com/";
    public void isAboutPageUrlShown(){
        String url = this.getDriver().getCurrentUrl();
        Assertions.assertThat(url).as("User should be on the about page").isEqualTo(ABOUT_PAGE_URL);
    }
}
