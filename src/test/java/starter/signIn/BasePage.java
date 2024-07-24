package starter.signIn;

import net.serenitybdd.screenplay.targets.Target;

class BasePage {
  static Target GO_TO_THE_CART_BUTTON =
      Target.the("go to the cart button")
          .locatedBy("div.shopping_cart a[title='View my shopping cart']");
  static Target SIGN_IN_BUTTON = Target.the("sign in button").locatedBy("div.header_user_info");
}
