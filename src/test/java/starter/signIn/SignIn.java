package starter.signIn;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class SignIn {
  public static Performable withEmail(String email) {
    return Task.where(
        "{0} entering '" + email + "'",
        Enter.theValue(email).into(SignInForm.EMAIL_ADDRESS_FILED),
        Click.on(SignInForm.CREATE_AN_ACCOUNT_BUTTON));
  }
}
