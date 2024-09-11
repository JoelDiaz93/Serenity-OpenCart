package starter.search;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.InputField;

class SearchInput {
    static Target SEARCH_FIELD = InputField.withNameOrId("search");
}

class SearchName {
    static Target SEARCH_FIELD = InputField.withNameOrId("firstname");
}

class SearchLastName {
    static Target SEARCH_FIELD = InputField.withNameOrId("lastname");
}

class SearchEmail {
    static Target SEARCH_FIELD = InputField.withNameOrId("email");
}

class SearchPhone {
    static Target SEARCH_FIELD = InputField.withNameOrId("telephone");
}

class SearchCompany {
    static Target SEARCH_FIELD = InputField.withNameOrId("company");
}

class SearchAddress {
    static Target SEARCH_FIELD = InputField.withNameOrId("address_1");
}

class SearchCity{
    static Target SEARCH_FIELD = InputField.withNameOrId("city");
}

class SearchPostCode {
    static Target SEARCH_FIELD = InputField.withNameOrId("postcode");
}

class SearchComment {
    static Target SEARCH_FIELD = InputField.withNameOrId("comment");
}



