package starter.pageObjects.ing;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class CurrentUrl {
  public static Question<String> value() {
    return Question.about("the current URL")
        .answeredBy(
            actor -> {
              WebDriver driver = BrowseTheWeb.as(actor).getDriver();
              return driver.getCurrentUrl();
            });
  }
}
