package starter.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import starter.pageObjects.search.LookForInformation;

public class SearchForProduct implements Interaction {
  private final String productName;

  public SearchForProduct(String productName) {
    this.productName = productName;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(LookForInformation.aboutEcommerce(productName));
  }
}
