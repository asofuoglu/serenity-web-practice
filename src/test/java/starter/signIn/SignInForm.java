package starter.signIn;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignInForm {
  public static final Target EMAIL_ADDRESS_FILED =
      Target.the("email address field").located(By.cssSelector("input#email_create"));
  public static final Target CREATE_AN_ACCOUNT_BUTTON =
      Target.the("create an account button").locatedBy("#SubmitCreate");
  public static final Target LOGIN_EMAIL_FIELD = Target.the("login email field").locatedBy("#email");
  public static final Target LOGIN_PASSWORD_FIELD = Target.the("login password field").locatedBy("#passwd");
  public static final Target LOGIN_BUTTON = Target.the("login button").locatedBy("#SubmitLogin");
}
