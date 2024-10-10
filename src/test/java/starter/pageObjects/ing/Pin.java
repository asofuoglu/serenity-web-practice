package starter.pageObjects.ing;

import static net.serenitybdd.core.Serenity.getDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import starter.Utils;

public class Pin implements Task {
  JavascriptExecutor js = (JavascriptExecutor) getDriver();

  @Override
  public <T extends Actor> void performAs(T actor) {
    Utils.waitForSomeTime(3);
    WaitUntil.the(PinsPage.PINPAD_HEADER, WebElementStateMatchers.isVisible())
        .forNoMoreThan(20)
        .seconds();
    for (int i = 0; i < 3; i++) {
      // Click.on(PinsPage.NUMBER_ONE);
      // Evaluate.javascript(PinsPage.ONE );
      try {
        js.executeScript(
            "document.querySelector('#meansContainer > ing-orange-it-pinpad')."
                + "shadowRoot.querySelector('.pinpad-keyboard')."
                + "shadowRoot.querySelector('button[aria-label=\"Uno\"]').click();");
      } catch (JavascriptException e) {
        System.out.println("First click failed, trying the second click.");
        try {
          js.executeScript(
              "document.querySelector('#meansContainer > ing-orange-it-secure-otp')."
                  + "shadowRoot.querySelector('smsotp-pinpad')."
                  + "shadowRoot.querySelector('.pinpad-keyboard')."
                  + "shadowRoot.querySelector('button[aria-label=\"Uno\"]').click();");
        } catch (JavascriptException ex) {
          System.out.println("Second click also failed: " + ex.getMessage());
        }
      }
    }
    // Click.on(PinsPage.CONTINUE_BUTTON);
    try {
      js.executeScript(
              "document.querySelector('#meansContainer > ing-orange-it-pinpad').shadowRoot.querySelector('.continue__button').click();");
    } catch (JavascriptException e) {
      System.out.println("First click failed, trying the second click.");

      try {
        js.executeScript(
                "document.querySelector('ing-orange-it-pinpad,ing-orange-it-secure-otp').shadowRoot.querySelector('smsotp-footer').shadowRoot.querySelector('.continue__button').click();");
      } catch (JavascriptException ex) {
        System.out.println("Second click also failed: " + ex.getMessage());
      }
    }

  }

  public static Performable select() {
    return Tasks.instrumented(Pin.class);
  }
}
