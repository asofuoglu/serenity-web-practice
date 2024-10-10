package starter.pageObjects.ing;

import static starter.pageObjects.ing.LoginForm.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Evaluate;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login implements Task {
  public static Performable withCredentials() {
    return Tasks.instrumented(Login.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(LoginForm.PERSON_ID_FIELD, WebElementStateMatchers.isVisible()),
        Enter.theValue("0001003738").into(LoginForm.PERSON_ID_FIELD),
        Enter.theValue("12/08/1996").into(LOGIN_DATE_OF_BIRTH_FIELD),
        Evaluate.javascript(CONTINUE_BUTTON + ".click();"),
        WaitUntil.the(LoginForm.PERSON_ID_FIELD, WebElementStateMatchers.isVisible())
            .forNoMoreThan(20)
            .seconds());
  }
}
