package starter.pageObjects.ing;

import static net.serenitybdd.core.Serenity.getDriver;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import starter.Utils;

public class OtpVerification {
  public static Performable viaSms(){
    return Task.where(
        "{0} enters credentials and continues",
        actor -> {
            Utils.waitForSomeTime(2);
            WaitUntil.the(SmsOtpPage.SMS_PAGE_HEADER, WebElementStateMatchers.isVisible())
                    .forNoMoreThan(20)
                    .seconds();
          JavascriptExecutor js = (JavascriptExecutor) getDriver();
          for (int i = 1; i < 7; i++) {
            WebElement personIdField =
                (WebElement)
                    js.executeScript(
                            "return document.querySelector(\"#meansContainer > ing-orange-it-smsotp\")." +
                                    "shadowRoot.querySelector(\"div > smsotp-input\").shadowRoot.querySelector(\"div > .secret-code-input\").shadowRoot.querySelector(\"div.secret-pad > input:nth-child("+i+")\");");
            personIdField.sendKeys(String.valueOf(i));
          }
          js.executeScript(
              "document.querySelector('ing-orange-it-identification').shadowRoot.querySelector('.continue__button').shadowRoot.querySelector('.button-content').click();");
        });
  }
}
