package starter.screenplay.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ProductListerPage {

  public static Question<String> listedProducts() {
    return Text.of("div.product-container a.product-name");
  }
}
