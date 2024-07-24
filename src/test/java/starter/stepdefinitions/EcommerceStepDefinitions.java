package starter.stepdefinitions;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static starter.plp.ProductListerPage.dynamicProductWebElement;

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
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.yaml.snakeyaml.Yaml;
import starter.Constants;
import starter.CredentialsNotFoundException;
import starter.Utils;
import starter.navigation.NavigateTo;
import starter.pdp.ProductDetailsPage;
import starter.search.LookForInformation;
import starter.signIn.*;

public class EcommerceStepDefinitions {
  private static final Faker faker = new Faker();
  Map<String, Object> addressData;
  public static String userMail, password;

  @Given("{actor} is navigating to the ecommerce website")
  public void researchingThings(Actor actor) {
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
  public void heEnterTheEmailAndClickOnCreateAnAccountButton(Actor actor) {
    String email = faker.internet().emailAddress();
    actor.remember("userMail", email);
    userMail = email;
    password = Constants.Credentials.password;
    actor.attemptsTo(SignIn.withEmail(email));
  }

  @And("{actor} fill the personal information form")
  public void heFillThePersonalInformationForm(Actor actor, DataTable dataTable) {
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

  @Then("{actor} fills the Address form")
  public void heFillsTheAddressForm(Actor actor) {
    loadAddressData();
    actor.attemptsTo(FillAddressForm.withDetails(addressData));
  }

  private void loadAddressData() {
    Yaml yaml = new Yaml();
    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("address.yaml");
    addressData = yaml.load(inputStream);
  }

  @When("{actor} clicks on the Save address button")
  public void heClicksOnTheSaveAddressButton(Actor actor) {
    actor.attemptsTo(Click.on(AddressFormPage.SUBMIT_BUTTON));
  }

  @Given("Mike logs in with his credentials")
  public void mikeLogsInWithHisCredentials() {}

  @Then("{actor} enter the email and password")
  public void heEnterTheEmailAndPassword(Actor actor) {
    if (userMail == null || password == null) {
      throw new CredentialsNotFoundException("Email or password cannot be null.");
    }
    actor.attemptsTo(Login.withCredentials(userMail, password));
  }

  @When("{actor} clicks on the log in button")
  public void heClicksOnTheLogInButton(Actor actor) throws InterruptedException {
    actor.attemptsTo(Click.on(SignInForm.LOGIN_BUTTON));
  }

  @And("{actor} selects the product {string}")
  public void heSelectsTheProduct(Actor actor, String productName) {
    actor.attemptsTo(Click.on(dynamicProductWebElement(productName)));
  }

  @Then("{actor} selects the product size {string}")
  public void heSelectsTheProductSize(Actor actor, String size) {
    getDriver().switchTo().frame(ProductDetailsPage.getProductDetailsIframe());
    actor.attemptsTo(
        SelectFromOptions.byVisibleText(size).from(ProductDetailsPage.PRODUCT_SIZE_DROPDOWN));
    Utils.waitForSomeTime(8);
  }
}
