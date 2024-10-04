package starter.screenplay.tasks;

import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import starter.pageObjects.signIn.PersonalInformationForm;
import starter.pageObjects.signIn.SignIn;
import starter.screenplay.interactions.FillPersonalInformationForm;

public class SignUp implements Task {
  private String email;
  private final Map<String, String> userDetails;

  public SignUp(String email, Map<String, String> userDetails) {
    this.email = email;
    this.userDetails = userDetails;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SignIn.withEmail(email),
        FillPersonalInformationForm.with(userDetails),
        Click.on(PersonalInformationForm.REGISTER_BUTTON));
  }

  public static SignUp with(String email, Map<String, String> userDetails) {
    return Tasks.instrumented(SignUp.class, email, userDetails);
  }
}
