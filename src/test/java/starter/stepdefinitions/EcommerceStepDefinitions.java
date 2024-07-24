package starter.stepdefinitions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

import com.github.javafaker.Faker;
import ecommerce.plp.ProductListerPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.yaml.snakeyaml.Yaml;
import starter.navigation.NavigateTo;
import starter.search.LookForInformation;
import starter.signIn.*;

public class EcommerceStepDefinitions {
  private static final Faker faker = new Faker();
  Map<String, Object> addressData;

  @Given("{actor} is navigating to the ecommerce website")
  public void researchingThings(Actor actor) throws InterruptedException {
    actor.wasAbleTo(NavigateTo.theEcommerceHomePage());
  }

  @When("{actor} looks up product {string}")
  public void searchesForEcommerce(Actor actor, String term) {
    actor.attemptsTo(LookForInformation.aboutEcommerce(term));
  }

  @Then("{actor} should see the product within results about {string}")
  public void shouldSeeTheProductWithinResultsAbout(Actor actor, String product) {
    actor.attemptsTo(Ensure.that(ProductListerPage.listedProducts()).containsIgnoringCase(product));
  }

  @When("{actor} clicks on the sign in button")
  public void heClicksOnTheSignInButton(Actor actor) {
    actor.attemptsTo(
        WaitUntil.the(By.cssSelector("div.header_user_info"), isPresent())
            .forNoMoreThan(10)
            .seconds(),
        Click.on(By.cssSelector("div.header_user_info")));
  }

  @Then("{actor} enter the email and click on Create an Account button")
  public void heEnterTheEmailAndClickOnCreateAnAccountButton(Actor actor)
      throws InterruptedException {
    actor.attemptsTo(SignIn.withEmail(faker.internet().emailAddress()));
  }

  @And("{actor} fill the personal information form")
  public void heFillThePersonalInformationForm(Actor actor, DataTable dataTable)
      throws InterruptedException {
    List<Map<String, String>> userDetailsList = dataTable.asMaps(String.class, String.class);
    Map<String, String> userDetails = userDetailsList.get(0);
    actor.attemptsTo(new FillPersonalInformation(userDetails));
  }

  @When("{actor} clicks on the register button")
  public void heClicksOnTheRegisterButton(Actor actor) {
    actor.attemptsTo(Click.on(PersonalInformationForm.REGISTER_BUTTON));
  }

  @Then("{actor} should see the title {string}")
  public void heShouldSeeTheTitle(Actor actor, String title) {
    actor.attemptsTo(Ensure.that(TheWebPage.title()).containsIgnoringCase(title));
  }

  @And("{actor} clicks on the add my first address button")
  public void heClicksOnTheAddMyFirstAddressButton(Actor actor) {
    actor.attemptsTo(Click.on(AccountPage.ADD_MY_FIRST_ADDRESS_BUTTON));
  }

  @Then("{actor} fills the Address form {}")
  public void heFillsTheAddressForm(Actor actor, String fileName) throws InterruptedException {
    loadAddressData(fileName);
    actor.attemptsTo(FillAddressForm.withDetails(addressData));
  }

  private void loadAddressData(String fileName) {
    Yaml yaml = new Yaml();
    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
    addressData = yaml.load(inputStream);
  }

  @When("{actor} clicks on the Save address button")
  public void heClicksOnTheSaveAddressButton(Actor actor) {
    actor.attemptsTo(Click.on(AddressFormPage.SUBMIT_BUTTON));
  }
}
