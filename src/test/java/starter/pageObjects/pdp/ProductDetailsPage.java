package starter.pageObjects.pdp;

import static net.serenitybdd.core.Serenity.getDriver;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import starter.Utils;

public class ProductDetailsPage {
  public static WebElement getProductDetailsIframe() {
    return getDriver().findElement(By.xpath("//iframe[contains(@id,'fancybox-frame')]"));
  }

  public static final Target PRODUCT_SIZE_DROPDOWN =
      Target.the("product size dropdown").located(By.cssSelector("#group_1"));

  public static final Target ADD_TO_CART_BUTTON =
      Target.the("add to cart button").located(By.cssSelector("p#add_to_cart button"));

  public static final Target PROCEED_TO_CHECKOUT_BUTTON =
      Target.the("Proceed to checkout").located(By.xpath("//a[@title='Proceed to checkout']"));
}
