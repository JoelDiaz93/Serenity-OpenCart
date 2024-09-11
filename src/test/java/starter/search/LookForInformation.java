package starter.search;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class LookForInformation extends PageObject {

    public static Performable about(String searchTerm) {
        return Task.where("{0} searches for '" + searchTerm + "'",
                Enter.theValue(searchTerm)
                        .into(SearchInput.SEARCH_FIELD)
                        .thenHit(Keys.ENTER)
        );
    }


    public static Performable infoPersonal(String name, String lastname, String email, String phone) {
        return Task.where(
                "{0} logs in as " + name,
                Click.on("#input-payment-firstname").afterWaitingUntilPresent(),
                Enter.theValue(name).into(SearchName.SEARCH_FIELD),
                Enter.theValue(lastname).into(SearchLastName.SEARCH_FIELD),
                Click.on("#input-payment-email").afterWaitingUntilPresent(),
                SendKeys.of(email).into(SearchEmail.SEARCH_FIELD),
                Enter.theValue(phone).into(SearchPhone.SEARCH_FIELD)
        );
    }

    public static Performable infoAddress(String company, String address1, String city, String postCode, String country, String region) {
        return Task.where(
                "{0} logs in as " + company,
                Enter.theValue(company).into(SearchCompany.SEARCH_FIELD),
                Enter.theValue(address1).into(SearchAddress.SEARCH_FIELD),
                SendKeys.of(city).into(SearchCity.SEARCH_FIELD),
                Enter.theValue(postCode).into(SearchPostCode.SEARCH_FIELD),
                Click.on(selectDropDownValuesCountry(country)),
                Click.on(selectDropDownValuesRegion(region))

        );
    }

    @FindBy(id="input-payment-country")
    static WebElementFacade dropDown_Country;

    public static String selectDropDownValuesCountry(String country){
        dropDown_Country.selectByVisibleText(country);
        return null;
    }

    @FindBy(id="input-payment-zone")
    static WebElementFacade dropDown_Region;

    public static String selectDropDownValuesRegion(String region){
        dropDown_Region.selectByVisibleText(region);
        return null;
    }

    public static Performable infoPayment(String comment) {
        return Task.where(
                "{0} logs in as " + comment,
                Enter.theValue(comment).into(SearchComment.SEARCH_FIELD),
                Click.on()

        );
    }
}
