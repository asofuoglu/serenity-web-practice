package starter.signIn;

import static starter.Utils.extractDateParts;

import com.github.javafaker.Faker;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.CheckCheckbox;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import starter.Constants;

public class FillPersonalInformation implements Task {
  private final Map<String, String> data;

  public FillPersonalInformation(Map<String, String> data) {
    this.data = data;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    Faker faker = new Faker();
    actor.remember("userPassword", data.get("password"));
    if ("Mr.".equals(data.get("title"))) {
      actor.attemptsTo(CheckCheckbox.of(PersonalInformationForm.TITLE_MR));
    } else {
      actor.attemptsTo(CheckCheckbox.of(PersonalInformationForm.TITLE_MRS));
    }
    actor.attemptsTo(
        Enter.theValue(data.get("firstname")).into(PersonalInformationForm.FIRST_NAME),
        Enter.theValue(data.get("lastname")).into(PersonalInformationForm.LAST_NAME),
        Enter.theValue(actor.recall("userMail").toString()).into(PersonalInformationForm.EMAIL),
        Enter.theValue(Constants.Credentials.password).into(PersonalInformationForm.PASSWORD),
        SelectFromOptions.byValue(extractDateParts(data.get("dateOfBirth"))[0])
            .from(PersonalInformationForm.DAY_OF_BIRTH),
        SelectFromOptions.byValue(extractDateParts(data.get("dateOfBirth"))[1])
            .from(PersonalInformationForm.MONTH_OF_BIRTH),
        SelectFromOptions.byValue(extractDateParts(data.get("dateOfBirth"))[2])
            .from(PersonalInformationForm.YEAR_OF_BIRTH),
        CheckCheckbox.of(PersonalInformationForm.NEWSLETTER_SIGNUP));
  }
}
