package starter.pageObjects.signIn;

import net.serenitybdd.screenplay.targets.Target;

public class PersonalInformationForm {
  public static final Target TITLE_MR = Target.the("Mr. title").locatedBy("#id_gender1");
  public static final Target TITLE_MRS = Target.the("Mrs. title").locatedBy("#id_gender2");
  public static final Target FIRST_NAME =
      Target.the("First name input").locatedBy("#customer_firstname");
  public static final Target LAST_NAME =
      Target.the("Last name input").locatedBy("#customer_lastname");
  public static final Target EMAIL = Target.the("Email input").locatedBy("#email");
  public static final Target PASSWORD = Target.the("Password input").locatedBy("#passwd");
  public static final Target DAY_OF_BIRTH =
      Target.the("Date of Birth dropdowns").locatedBy("#days");
  public static final Target MONTH_OF_BIRTH =
      Target.the("Date of Birth dropdowns").locatedBy("#months");
  public static final Target YEAR_OF_BIRTH =
      Target.the("Date of Birth dropdowns").locatedBy("#years");
  public static final Target NEWSLETTER_SIGNUP =
      Target.the("Newsletter signup").locatedBy("#newsletter");
  public static final Target REGISTER_BUTTON =
      Target.the("Register button").locatedBy("#submitAccount");
}
