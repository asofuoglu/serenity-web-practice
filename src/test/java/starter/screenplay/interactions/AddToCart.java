package starter.screenplay.interactions;

import static net.serenitybdd.core.Serenity.getDriver;

import java.util.Arrays;
import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.Utils;
import starter.pageObjects.pdp.ProductDetailsPage;

public class AddToCart implements Interaction {

  public AddToCart() {}

  @Override
  public <T extends Actor> void performAs(T actor) {
    getDriver().switchTo().frame(ProductDetailsPage.getProductDetailsIframe());
    List<String> sizes = Arrays.asList("S", "M", "L");
    for (String size : sizes) {
      actor.attemptsTo(
          SelectFromOptions.byVisibleText(size).from(ProductDetailsPage.PRODUCT_SIZE_DROPDOWN));
      Utils.waitForSomeTime(1);

      if (actor.asksFor(Visibility.of(ProductDetailsPage.ADD_TO_CART_BUTTON))) {
        actor.attemptsTo(Click.on(ProductDetailsPage.ADD_TO_CART_BUTTON));
        break;
      }
    }
    getDriver().switchTo().defaultContent();
  }
}
