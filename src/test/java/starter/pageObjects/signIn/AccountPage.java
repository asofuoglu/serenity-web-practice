package starter.pageObjects.signIn;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccountPage {
  public static final Target ACCOUNT_PAGE_TITLE =
      Target.the("account text").locatedBy("div#center_column h1");
  public static final Target ADD_MY_FIRST_ADDRESS_BUTTON =
      Target.the("Add my first address button")
          .located(By.cssSelector("a[title='Add my first address']"));
}
