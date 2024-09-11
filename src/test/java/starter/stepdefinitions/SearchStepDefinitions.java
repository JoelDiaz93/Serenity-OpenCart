package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.*;
import starter.navigation.NavigateTo;
import starter.search.LookForInformation;

public class SearchStepDefinitions {

    @Given("{actor} is researching things on the internet")
    public void researchingThings(Actor actor) {
        actor.wasAbleTo(NavigateTo.theSearchHomePage());
    }

    @When("{actor} looks up {string}")
    public void searchesFor(Actor actor, String term) {
        actor.attemptsTo(
                LookForInformation.about(term)
        );
    }

    @When("{actor} select article {string}")
    public void searchesArticle(Actor actor, String term) {
        actor.attemptsTo(
                Scroll.to("#content"),
                Click.on(Image.withAltText(term))
        );
    }

    @When("{actor} click to {string}")
    public void clickAddToCart(Actor actor, String term) {
        actor.attemptsTo(
                Click.on("#button-cart")
        );
    }


    @When("{actor} should see alert success buy to {string}")
    public void should_see_alert(Actor actor, String term) {
        actor.attemptsTo(
                //Scroll.to("#product-product"),

                //Ensure.that(Validation.SUCCESS.toString()).containsIgnoringCase(term)

                Ensure.that(Target.the("Success ").locatedBy(".alert alert-success alert-dismissible").toString()).containsIgnoringCase("Success")
        );

    }

    @When("{actor} click to view cart and CheckOut")
    public void clickCartTotal(Actor actor) {
        actor.attemptsTo(
                Click.on("#cart-total").afterWaitingUntilPresent(),
                Click.on(Link.locatedBy(".text-right").containingText("Cart")),
                Click.on(Link.withText("Checkout"))
        );
    }

    @When("{actor} select a {string}")
    public void clickCartTotal(Actor actor, String term) {
        actor.attemptsTo(
                Click.on(RadioButton.withLabel(term))
        );
    }

    @When("{actor} click to Continue")
    public void clickContinue(Actor actor) {
        actor.attemptsTo(
                Click.on(Button.withText("Continue"))
        );
    }


    @When("{actor} enters his personal {string}, {string}, {string}, {string}")
    public void informationPersonal(Actor actor, String name, String lastName, String email, String phone) {
        actor.attemptsTo(
                LookForInformation.infoPersonal(name, lastName, email, phone)
        );
    }

    @When("{actor} enters his address {string}, {string}, {string}, {string}, {string}, {string}")
    public void informationAddress(Actor actor, String company, String address1, String city, String postCode, String country, String region) {
        actor.attemptsTo(
                LookForInformation.infoAddress(company, address1, city, postCode, country, region)
        );
    }

    @When("{actor} payment method")
    public void paymentMethod(Actor actor) {
        actor.attemptsTo(
                Click.on(Checkbox.withValue("1"))
        );
    }

    @Then("{actor} should see alert success order")
    public void should_see_information_about(Actor actor) {
        actor.attemptsTo(
                Ensure.that(Target.the("Success ").locatedBy("#content").toString()).containsIgnoringCase("Your order has been placed!")
        );
    }

}
