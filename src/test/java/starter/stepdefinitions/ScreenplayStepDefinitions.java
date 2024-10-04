package starter.stepdefinitions;

import static starter.pageObjects.plp.ProductListerPage.dynamicProductWebElement;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import starter.pageObjects.navigation.NavigateTo;
import starter.pageObjects.search.LookForInformation;
import starter.screenplay.interactions.AddToCart;
import starter.screenplay.interactions.ClickProceedToCheckout;
import starter.screenplay.questions.ProductListerPage;
import starter.screenplay.tasks.SignUp;

public class ScreenplayStepDefinitions {
  private static final Faker faker = new Faker();

  @Given("{actor} is on the homepage")
  public void theUserIsOnTheHomepageA(Actor actor) {
    actor.wasAbleTo(NavigateTo.theEcommerceHomePage());
  }

  @When("{actor} proceeds to checkout")
  @Step("{actor} proceeds to checkout")
  public void theUserProceedsToCheckout(Actor actor) {
    actor.attemptsTo(ClickProceedToCheckout.on());
  }

  @And("{actor} adds item to the cart with size")
  public void heAddsItemToTheCartWithSize(Actor actor) {}

  @When("{actor} searches for {string} and adds available product to the cart")
  @Step("User searches for {string} and adds available product to the cart")
  public void heSearchesForAndAddsAvailableProductToTheCart(Actor actor, String product) {
    actor.attemptsTo(
        LookForInformation.aboutEcommerce(product),
        Ensure.that(ProductListerPage.listedProducts()).containsIgnoringCase(product),
        Click.on(dynamicProductWebElement(product)),
        new AddToCart());
  }

  @Then("{actor} should see the order successfully placed")
  @Step("{actor} should see the order successfully placed")
  public void heShouldSeeTheOrderSuccessfullyPlaced(Actor actor) {
    actor.attemptsTo(Ensure.that(TheWebPage.title()).containsIgnoringCase("order"));
  }

  @Given("{actor} is on the homepage and Sign in")
  @Step("User is on the homepage and Sign in")
  public void mikeIsOnTheHomepageAndSignIn(Actor actor, DataTable dataTable) {
    String email = faker.internet().emailAddress();
    actor.remember("userMail", email);
    List<java.util.Map<String, String>> userDetailsList =
        dataTable.asMaps(String.class, String.class);
    Map<String, String> userDetails = userDetailsList.get(0);
    actor.wasAbleTo(NavigateTo.theEcommerceHomePage(), SignUp.with(email, userDetails));
  }
}
