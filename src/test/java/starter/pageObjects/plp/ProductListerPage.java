package starter.pageObjects.plp;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductListerPage {
  public static Target dynamicProductWebElement(String productName) {
    return Target.the("dynamic product element")
        .located(
            By.xpath(
                String.format(
                    "//div[@class='product-image-container']//a[contains(@title, '%s')]",
                    productName)));
  }
}
