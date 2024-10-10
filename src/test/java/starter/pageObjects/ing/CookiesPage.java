package starter.pageObjects.ing;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.core.Serenity.getDriver;

public class CookiesPage {
  public static final Target COOKIES_COMPONENT_BASE_ELEMENT =
      Target.the("Cookies component")
          .locatedBy("//*[@data-tag-name='ing-feat-cookie-preference-it']");
  public static final Target COOKIE =
      Target.the("Cookie")
          .located(
              ByShadow.cssSelector(
                  "[label='Tutti i cookies'] label",
                  "[data-tag-name='ing-feat-cookie-preference-it']",
                  "[data-tag-name='ing-feat-cookie-preference']"));
  public static final Target SUBMIT_BUTTON =
          Target.the("Submit")
                  .located(
                          ByShadow.cssSelector(
                                  ".submit-button",
                                  "[data-tag-name='ing-feat-cookie-preference-it']",
                                  "[data-tag-name='ing-feat-cookie-preference']"));
}
