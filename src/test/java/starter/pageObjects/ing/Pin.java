package starter.pageObjects.ing;

import static net.serenitybdd.core.Serenity.getDriver;
import static starter.pageObjects.ing.PinsPage.*;

import java.time.Duration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
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
        actor.attemptsTo(
            WaitUntil.the(NUMBER_ONE, WebElementStateMatchers.isVisible())
                .forNoMoreThan(Duration.ofSeconds(10)),
            Click.on(NUMBER_ONE));
      } catch (Exception ex) {
        actor.attemptsTo(
            WaitUntil.the(NUMBER_ONE_ALTERNATIVE, WebElementStateMatchers.isVisible())
                .forNoMoreThan(Duration.ofSeconds(10)),
            Click.on(NUMBER_ONE));
      }
    }
    // selectPinOne();
    // Click.on(PinsPage.CONTINUE_BUTTON);
    // clickOnContinue();
    try {
      actor.attemptsTo(
          WaitUntil.the(CONTINUE_BUTTON, WebElementStateMatchers.isVisible())
              .forNoMoreThan(Duration.ofSeconds(10)),
          Click.on(CONTINUE_BUTTON));
    } catch (Exception ex) {
      actor.attemptsTo(
          WaitUntil.the(CONTINUE_BUTTON_ALTERNATIVE, WebElementStateMatchers.isVisible())
              .forNoMoreThan(Duration.ofSeconds(10)),
          Click.on(CONTINUE_BUTTON_ALTERNATIVE));
    }
  }

  public static Performable select() {
    return Tasks.instrumented(Pin.class);
  }

  private void selectPinOneByJs() {
    try {
      js.executeScript(
          "document.querySelector('#meansContainer > ing-orange-it-pinpad')."
              + "shadowRoot.querySelector('.pinpad-keyboard')."
              + "shadowRoot.querySelector('button[aria-label=\"Uno\"]').click();");
    } catch (Exception e) {
      System.out.println("First click failed, trying the second click.");
      try {
        js.executeScript(
            "document.querySelector('#meansContainer > ing-orange-it-secure-otp')."
                + "shadowRoot.querySelector('smsotp-pinpad')."
                + "shadowRoot.querySelector('.pinpad-keyboard')."
                + "shadowRoot.querySelector('button[aria-label=\"Uno\"]').click();");
      } catch (Exception ex) {
        System.out.println("Second click also failed: " + ex.getMessage());
      }
    }
  }

  private void clickOnContinueByJs() {
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
}
