package starter.stepdefinitions;

import static net.serenitybdd.core.Serenity.getDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.JavascriptExecutor;
import starter.pageObjects.ing.Cookies;
import starter.pageObjects.ing.Login;
import starter.pageObjects.ing.Pin;
import starter.pageObjects.navigation.NavigateTo;

public class IngStepDefinitions {
  JavascriptExecutor js = (JavascriptExecutor) getDriver();

  @Given("{actor} is on the login page")
  public void mikeIsOnTheLoginPage(Actor actor) throws InterruptedException {
    actor.wasAbleTo(NavigateTo.theLoginPage(), Cookies.accept());
  }

  @When("{actor} enter the credentials")
  public void heEnterTheCredentials(Actor actor) {
    actor.attemptsTo(Login.withCredentials());
  }

  @And("{actor} enter pin")
  public void heEnterPin(Actor actor) throws InterruptedException {
    actor.attemptsTo(Pin.select());
  }
}
