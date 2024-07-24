package starter.signIn;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

public class PageTitle {
    public static Question<String> title() {
        return actor -> String.valueOf(TheWebPage.title());
    }
}

