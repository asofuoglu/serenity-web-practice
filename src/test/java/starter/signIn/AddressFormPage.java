package starter.signIn;

import net.serenitybdd.screenplay.targets.Target;

public class AddressFormPage {
  public static final Target FIRST_NAME_FIELD =
      Target.the("First name field").locatedBy("#firstname");
  public static final Target LAST_NAME_FIELD = Target.the("Last name field").locatedBy("#lastname");
  public static final Target COMPANY_FIELD = Target.the("Company field").locatedBy("#company");
  public static final Target ADDRESS_LINE_1_FIELD =
      Target.the("Address line 1 field").locatedBy("#address1");
  public static final Target ADDRESS_LINE_2_FIELD =
      Target.the("Address line 2 field").locatedBy("#address2");
  public static final Target CITY_FIELD = Target.the("City field").locatedBy("#city");
  public static final Target STATE_FIELD = Target.the("State dropdown").locatedBy("#id_state");
  public static final Target ZIP_CODE_FIELD = Target.the("Zip/Postal Code field").locatedBy("#postcode");
  public static final Target COUNTRY_FIELD = Target.the("Country dropdown").locatedBy("#id_country");
  public static final Target HOME_PHONE_FIELD =
      Target.the("Home phone field").locatedBy("#phone");
  public static final Target MOBILE_PHONE_FIELD =
      Target.the("Mobile phone field").locatedBy("#phone_mobile");
  public static final Target ADDITIONAL_INFO_FIELD =
      Target.the("Additional information field").locatedBy("#other");
  public static final Target ADDRESS_TITLE_FIELD =
      Target.the("Address title field").locatedBy("#alias");
  public static final Target SUBMIT_BUTTON = Target.the("Save button").locatedBy("#submitAddress");
}
