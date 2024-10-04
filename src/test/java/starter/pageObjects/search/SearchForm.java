package starter.pageObjects.search;

import net.serenitybdd.screenplay.targets.Target;

class SearchForm {
  static Target SEARCH_FIELD = Target.the("search field").locatedBy("#searchbox_input");
  static Target ECOMMERCE_SEARCH_FIELD = Target.the("search field").locatedBy("#search_query_top");
}
