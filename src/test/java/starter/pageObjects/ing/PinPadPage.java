package starter.pageObjects.ing;

import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class PinPadPage extends PageObject {

    @FindBy(css = "[id^='key-']")
    private List<WebElementFacade> pinPadButtons;

    public void clickNumberOnPinPad(String number) {
        for (WebElementFacade button : pinPadButtons) {
            if (button.getText().trim().equals(number)) {
                button.click();
                break;
            }
        }
    }
}
