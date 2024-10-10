package starter.pageObjects.ing;


import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;

public class LoginForm {
  public static final String PERSON_ID_FIEL =
      "return document.querySelector('ing-orange-it-identification').shadowRoot.querySelector('#customerCode input')";
  public static final Target PERSON_ID_FIELD =
      Target.the("Cookie")
          .located(ByShadow.cssSelector("#customerCode input", "ing-orange-it-identification"));

  public static final String LOGIN_DATE_OF_BIRTH_FIEL =
      "return document.querySelector('ing-orange-it-identification').shadowRoot.querySelector('input[name=\"dateOfBirth\"]')";

  public static final Target LOGIN_DATE_OF_BIRTH_FIELD =
      Target.the("Cookie")
          .located(
              ByShadow.cssSelector("input[name='dateOfBirth']", "ing-orange-it-identification"));

  public static final String CONTINUE_BUTTON =
      "document.querySelector('ing-orange-it-identification').shadowRoot.querySelector('.continue__button').shadowRoot.querySelector('.button-content')";
  public static final Target CONTINUE_BUTTON1 =
      Target.the("Continue button")
          .located(
              ByShadow.cssSelector(
                  ".button-content", "ing-orange-it-identification", ".continue__button"));
}
