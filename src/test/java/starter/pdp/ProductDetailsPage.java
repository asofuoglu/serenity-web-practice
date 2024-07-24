package starter.pdp;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.core.Serenity.getDriver;

public class ProductDetailsPage {
  public static WebElement getProductDetailsIframe() {
    return getDriver().findElement(By.xpath("//iframe[contains(@id,'fancybox-frame')]"));
  }
  public static final Target PRODUCT_SIZE_DROPDOWN =
      Target.the("product size dropdown").located(By.cssSelector("#group_1"));
}
