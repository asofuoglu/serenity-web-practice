package starter.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import starter.pageObjects.pdp.ProductDetailsPage;

public class ClickProceedToCheckout implements Interaction {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(ProductDetailsPage.PROCEED_TO_CHECKOUT_BUTTON));
  }

  public static ClickProceedToCheckout on() {
    return Tasks.instrumented(ClickProceedToCheckout.class);
  }
}
