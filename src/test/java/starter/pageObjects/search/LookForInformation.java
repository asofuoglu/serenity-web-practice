package starter.pageObjects.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class LookForInformation {
  public static Performable about(String searchTerm) {
    return Task.where(
        "{0} searches for '" + searchTerm + "'",
        Enter.theValue(searchTerm).into(SearchForm.SEARCH_FIELD).thenHit(Keys.ENTER));
  }

  public static Performable aboutEcommerce(String searchTerm) {
    return Task.where(
        "{0} searches for '" + searchTerm + "'",
        Enter.theValue(searchTerm).into(SearchForm.ECOMMERCE_SEARCH_FIELD).thenHit(Keys.ENTER));
  }
}
