package starter.stepdefinitions;

import static net.serenitybdd.core.Serenity.getDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import starter.Utils;
import starter.pageObjects.ing.Cookies;
import starter.pageObjects.ing.Login;
import starter.pageObjects.ing.Pin;
import starter.pageObjects.navigation.NavigateTo;

public class IngStepDefinitions {
  JavascriptExecutor js = (JavascriptExecutor) getDriver();

  @Given("{actor} is on the login page")
  public void mikeIsOnTheLoginPage(Actor actor) {
    actor.wasAbleTo(NavigateTo.theLoginPage(), Cookies.accept());
  }

  @When("{actor} enter the credentials")
  public void heEnterTheCredentials(Actor actor) {
    actor.attemptsTo(Login.withCredentials());
  }

  @And("{actor} enter pin")
  public void heEnterPin(Actor actor) {
    actor.attemptsTo(Pin.select());
    Utils.waitForSomeTime(5);
  }

  @Then("{actor} navigated to the homepage")
  public void heNavigatedToTheHomepage(Actor actor) {
    actor.attemptsTo(
        WaitUntil.the(ExpectedConditions.urlContains("banking/overview"))
            .forNoMoreThan(Duration.ofSeconds(30)));
  }
}
