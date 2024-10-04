package starter.pageObjects.signIn;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class Login {
  public static Performable withCredentials(String email, String password) {
    return Task.where(
        String.format("Entering email '%s' and password '%s'", email, password),
        Enter.theValue(email).into(SignInForm.LOGIN_EMAIL_FIELD),
        Enter.theValue(password).into(SignInForm.LOGIN_PASSWORD_FIELD));
  }
}
