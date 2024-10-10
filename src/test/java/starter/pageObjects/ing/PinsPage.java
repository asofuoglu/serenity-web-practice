package starter.pageObjects.ing;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;

public class PinsPage {
  public static final Target NUMBER_ONE =
      Target.the("Pin number one -1")
          .located(
              ByShadow.cssSelector(
                  "button[aria-label='Uno']",
                  "#meansContainer > ing-orange-it-pinpad",
                  ".pinpad-keyboard"));
  public static final Target CONTINUE_BUTTON =
      Target.the("Continue button")
          .located(
              ByShadow.cssSelector(".continue__button", "#meansContainer > ing-orange-it-pinpad"));

  public static final Target PINPAD_HEADER =
      Target.the("Pin pad Header text")
          .located(ByShadow.cssSelector(".position-header-text", "ing-orange-it-pinpad"));
  // document.querySelector("#meansContainer >
  // ing-orange-it-pinpad").shadowRoot.querySelector(".continue__button")
  public static final String ONE =
      "document.querySelector('#meansContainer > ing-orange-it-pinpad').shadowRoot.querySelector('.pinpad-keyboard').shadowRoot.querySelector('button[aria-label=\"Uno\"]')";
}
