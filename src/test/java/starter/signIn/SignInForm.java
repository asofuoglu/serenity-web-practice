package starter.signIn;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignInForm {
  static Target EMAIL_ADDRESS_FILED =
      Target.the("email address field").located(By.cssSelector("input#email_create"));
  static Target CREATE_AN_ACCOUNT_BUTTON =
      Target.the("create an account").locatedBy("#SubmitCreate");
}
