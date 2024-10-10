package starter.screenplay.interactions;

import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import starter.pageObjects.signIn.FillPersonalInformation;

public class FillPersonalInformationForm implements Interaction {
  private final Map<String, String> userDetails;

  public FillPersonalInformationForm(Map<String, String> userDetails) {
    this.userDetails = userDetails;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(new FillPersonalInformation(userDetails));
  }

  public static FillPersonalInformationForm with(Map<String, String> userDetails) {
    return Tasks.instrumented(FillPersonalInformationForm.class, userDetails);
  }
}
