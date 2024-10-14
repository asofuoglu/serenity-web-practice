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

public class Login {
  public static Performable withCredentials(String personId, String dob) {
    return Task.where(
        "{0} logs in using person ID: " + personId,
        WaitUntil.the(LoginForm.PERSON_ID_FIELD, WebElementStateMatchers.isVisible()),
        Enter.theValue(personId).into(LoginForm.PERSON_ID_FIELD), // 0001000020
        Enter.theValue(dob).into(LOGIN_DATE_OF_BIRTH_FIELD), // 26/04/1972
        Evaluate.javascript(CONTINUE_BUTTON + ".click();"),
        WaitUntil.the(LoginForm.PERSON_ID_FIELD, WebElementStateMatchers.isVisible())
            .forNoMoreThan(20)
            .seconds());
  }
}
