package starter.pageObjects.signIn;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class FillAddressForm implements Task {

  private final Map<String, Object> addressData;

  public FillAddressForm(Map<String, Object> addressData) {
    this.addressData = addressData;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    System.out.println(addressData.get("first_name").toString());
    actor.attemptsTo(
        Enter.theValue((String) addressData.get("first_name"))
            .into(AddressFormPage.FIRST_NAME_FIELD),
        Enter.theValue((String) addressData.get("last_name")).into(AddressFormPage.LAST_NAME_FIELD),
        Enter.theValue((String) addressData.get("company")).into(AddressFormPage.COMPANY_FIELD),
        Enter.theValue((String) addressData.get("address_line_1"))
            .into(AddressFormPage.ADDRESS_LINE_1_FIELD),
        Enter.theValue((String) addressData.get("address_line_2"))
            .into(AddressFormPage.ADDRESS_LINE_2_FIELD),
        Enter.theValue((String) addressData.get("city")).into(AddressFormPage.CITY_FIELD),
        SelectFromOptions.byVisibleText((String) addressData.get("state"))
            .from(AddressFormPage.STATE_FIELD),
        Enter.theValue((String) addressData.get("zip_postal_code"))
            .into(AddressFormPage.ZIP_CODE_FIELD),
        Enter.theValue((String) addressData.get("home_phone"))
            .into(AddressFormPage.HOME_PHONE_FIELD),
        Enter.theValue((String) addressData.get("mobile_phone"))
            .into(AddressFormPage.MOBILE_PHONE_FIELD),
        Enter.theValue((String) addressData.get("additional_information"))
            .into(AddressFormPage.ADDITIONAL_INFO_FIELD),
        Enter.theValue((String) addressData.get("address_title"))
            .into(AddressFormPage.ADDRESS_TITLE_FIELD));
  }

  public static FillAddressForm withDetails(Map<String, Object> addressData) {
    return instrumented(FillAddressForm.class, addressData);
  }
}
