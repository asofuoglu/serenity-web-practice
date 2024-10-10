package starter.pageObjects.ing;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.Utils;

public class Cookies implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {
    Utils.waitForSomeTime(2);
    actor.attemptsTo(
        WaitUntil.the(CookiesPage.COOKIE, WebElementStateMatchers.isPresent()),
        Click.on(CookiesPage.COOKIE),
        Click.on(CookiesPage.SUBMIT_BUTTON));

    /*Target.the("dynamic product element")
    .located(
        ByShadow.cssSelector(
            "[label=\"Tutti i cookies\"] label')",
            "[data-tag-name=\"ing-feat-cookie-preference-it\"]",
            "[data-tag-name=\"ing-feat-cookie-preference\"]"));*/
    /* js.executeScript(
    "document.querySelector('[data-tag-name=\"ing-feat-cookie-preference-it\"]')"
            + ".shadowRoot.querySelector('[data-tag-name=\"ing-feat-cookie-preference\"]')"
            + ".shadowRoot.querySelector('[label=\"Tutti i cookies\"] label').click();");*/
    /* Target.the("dynamic product element")
        .located(
            ByShadow.cssSelector(
                ".submit-button",
                "[data-tag-name=\"ing-feat-cookie-preference-it\"]",
                "[data-tag-name=\"ing-feat-cookie-preference\"]"));
    js.executeScript(
        "document.querySelector('[data-tag-name=\"ing-feat-cookie-preference-it\"]')"
            + ".shadowRoot.querySelector('[data-tag-name=\"ing-feat-cookie-preference\"]')"
            + ".shadowRoot.querySelector('.submit-button').click();");*/
  }

  public static Performable accept() {
    return Tasks.instrumented(Cookies.class);
  }
}
