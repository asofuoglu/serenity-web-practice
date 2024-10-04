package starter.pageObjects.navigation;

import starter.pageObjects.EcommerceHomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
  public static Performable theSearchHomePage() {
    return Task.where(
        "{0} opens the DuckDuckGo home page", Open.browserOn().the(DuckDuckGoHomePage.class));
  }

  public static Performable theEcommerceHomePage() {
    return Task.where(
        "{0} opens the Ecommerce home page", Open.browserOn().the(EcommerceHomePage.class));
  }
}
