package starter.pageObjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("http://www.automationpractice.pl/index.php")
public class EcommerceHomePage extends PageObject {
  public static final Target SIGN_IN_BUTTON =
      Target.the("sign in button").located(By.cssSelector("div.header_user_info"));
}
