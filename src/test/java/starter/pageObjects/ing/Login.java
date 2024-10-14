package starter.pageObjects.ing;

import static starter.pageObjects.ing.LoginForm.*;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Evaluate;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

public class Login {
  public static Performable withCredentials(String personId, String dob) {
    return Task.where(
        "{0} logs in using person ID: " + personId,
        actor -> {
          actor.attemptsTo(
              WaitUntil.the(LoginForm.PERSON_ID_FIELD, WebElementStateMatchers.isVisible()),
              Enter.theValue(personId).into(LoginForm.PERSON_ID_FIELD), // 0001000020
              Enter.theValue(dob).into(LOGIN_DATE_OF_BIRTH_FIELD), // 26/04/1972
              // Evaluate.javascript(CONTINUE_BUTTON + ".click();"),
              WaitUntil.the(CONTINUE_BUTTON1, WebElementStateMatchers.isVisible())
                  .forNoMoreThan(Duration.ofSeconds(10)),
              Click.on(CONTINUE_BUTTON1),
              WaitUntil.the(LoginForm.PERSON_ID_FIELD, WebElementStateMatchers.isVisible())
                  .forNoMoreThan(20)
                  .seconds());
        });
  }
}
