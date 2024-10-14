package starter.pageObjects.ing;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;

public class SmsOtpPage {
  public static final Target SMS_PAGE_HEADER =
      Target.the("SMS_PAGE_HEADER")
          .located(
              ByShadow.cssSelector(
                  "div > div.position-header-text",
                  "#meansContainer > ing-orange-it-smsotp",
                  "smsotp-header"));
}
