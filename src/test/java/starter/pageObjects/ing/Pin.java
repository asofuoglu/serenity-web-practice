package starter.pageObjects.ing;

import static net.serenitybdd.core.Serenity.getDriver;

import java.time.Duration;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
      selectPinOne();
    }
    // Click.on(PinsPage.CONTINUE_BUTTON);
    clickOnContinue();
  }

  public static Performable select() {
    return Tasks.instrumented(Pin.class);
  }

  private void selectPinOne() {
    try {
      WaitUntil.the(
              Target.the("Pin number one -1")
                      .located(ByShadow.cssSelector("button[aria-label=\"Uno\"]", "#meansContainer > ing-orange-it-pinpad")),
              WebElementStateMatchers.isVisible()
      ).forNoMoreThan(Duration.ofSeconds(10));
      Click.on(Target.the("Pin number one -1")
              .located(ByShadow.cssSelector("button[aria-label=\"Uno\"]", "#meansContainer > ing-orange-it-pinpad")));
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

  private void waitUntilPinPadVisible() {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
    WebElement shadowHost =
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#meansContainer > ing-orange-it-pinpad")));
  }

  private void clickOnContinue() {
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
