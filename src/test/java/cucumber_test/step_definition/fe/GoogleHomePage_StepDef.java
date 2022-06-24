package cucumber_test.step_definition.fe;

import cucumber_test.page_object_model.fe.GoogleHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleHomePage_StepDef {
    @Given("User navigates to google URL")
    public void userNavigatesToGoogleURL() {
        GoogleHomePage.navigateToGoogleHomePage();
    }

    @When("User successfully navigated")
    public void userSuccessfullyNavigated() {
        GoogleHomePage.validateThatUserRedirectedSuccessfully();
    }

    @Then("User should see google logo icon displayed")
    public void userShouldSeeGoogleLogoIconDisplayed() {
        GoogleHomePage.validateThatGoogleLogoIconExists();
    }

    @Then("User should see google search bar displayed")
    public void userShouldSeeGoogleSearchBarDisplayed() {
        GoogleHomePage.validateThatGoogleSearchBarExists();
    }

    @Then("User should see google buttons displayed")
    public void userShouldSeeGoogleButtonsDisplayed() {
        GoogleHomePage.validateThatGoogleSearchButtonsDisplayed();
    }

    @And("User should see google buttons enabled")
    public void userShouldSeeGoogleButtonsEnabled() {
        GoogleHomePage.validateThatGoogleSearchButtonClickable();
    }
}
