package stepDefinitions;

import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.ReusableMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.N11Page;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MyStepdefs {

    Actions actions = new Actions(Driver.getDriver());
    N11Page n11Page = new N11Page();


    @Given("User go to homepage")
    public void userGoToHomepage() {

    }

    @When("Confirm that it went to the homepage")
    public void confirmThatItWentToTheHomepage() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = ("n11 - 10 Üzerinden 11'lik Alışveriş Deneyimi");

        assertEquals(expectedTitle, actualTitle);
        System.out.println("ActTitle ->" + actualTitle + " " +
                "ExpTitle ->" + expectedTitle);
    }

    @And("User click to login button")
    public void userClickToLoginButton() {

        n11Page.signInButton.click();

    }

    @And("Verifies that the login page has loaded")
    public void verifiesThatTheLoginPageHasLoaded() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Giriş Yap - n11";

        assertEquals(expectedTitle, actualTitle);


       /* Another use
         String actUrl= Driver.getDriver().getCurrentUrl();
         System.out.println("Url -> " + actUrl);

         assert actUrl != null;
         if (actUrl.equals("Giriş Yap - n11")){
             System.out.println("loginpage has successfuly loaded ");
         }else
             System.out.println("loginpage loaded has failed");

        */
    }

    @And("User enters valid username and password")
    public void userEntersValidUsernameAndPassword() {

        n11Page.email.sendKeys(ConfigReader.getProperty("eMail"));
        n11Page.password.sendKeys(ConfigReader.getProperty("password"));

        n11Page.loginButton.click();

    }

    @Then("User verifies successful login")
    public void userVerifiesSuccessfulLogin() {

        assertTrue(n11Page.myAccount.isEnabled());

        actions.moveToElement(n11Page.myAccount).perform();
        assertTrue(n11Page.exitButton.isEnabled());

        if (n11Page.myAccount.isDisplayed()) {
            System.out.println("Login was succesfully");
        } else
            System.out.println("Login failed");

    }

    @And("User does not fill in eMail and password")
    public void userDoesNotFillInEMailAndPassword() {
        n11Page.loginButton.click();

        assertTrue(n11Page.errorWarning1.isEnabled());
        assertTrue(n11Page.errorWarning2.isEnabled());
    }

    @And("The user only fills in the eMail section")
    public void theUserOnlyFillsInTheEMailSection() {
        Driver.getDriver().navigate().refresh();
        n11Page.email.sendKeys(ConfigReader.getProperty("eMailWr"));
        n11Page.loginButton.click();

        assertTrue(n11Page.errorWarning2.isEnabled());
    }

    @And("The user only fills the password section")
    public void theUserOnlyFillsThePasswordSection() {
        Driver.getDriver().navigate().refresh();
        n11Page.password.sendKeys(ConfigReader.getProperty("wrPassword"));
        n11Page.loginButton.click();

        assertTrue(n11Page.errorWarning1.isEnabled());
    }

    @And("User enters incorrect information")
    public void userEntersIncorrectInformation() {
        Driver.getDriver().navigate().refresh();
        n11Page.email.sendKeys(ConfigReader.getProperty("eMailWr"));
        n11Page.password.sendKeys(ConfigReader.getProperty("wrPassword"));
        n11Page.loginButton.click();

    }

    @Then("User incorrect information is verified")
    public void userIncorrectInformationIsVerified() {
        assertTrue(n11Page.mainErrorWarning.isEnabled());

    }
    @When("User searches for a product and clicks")
    public void userSearchesForAProductAndClicks() {
    n11Page.searchField.sendKeys(ConfigReader.getProperty("searchBoxTxt")+Keys.ENTER);

    }

    @Then("User adds the product to the cart")
    public void userAddsTheProductToTheCart() {

        assertTrue(n11Page.product.isDisplayed());

        n11Page.oneTbLabel.click();
        n11Page.firstProduct.click();

        ReusableMethod.overHover(n11Page.addToCardButton);
        n11Page.addToCardButton.click();

        Driver.getDriver().navigate().refresh();
        ReusableMethod.overHover(n11Page.searchField);
        n11Page.goToCartButton.click();

    }

    @And("Verify that the product is in the cart")
    public void verifyThatTheProductIsInTheCart() {
        String expectedUrl = Driver.getDriver().getCurrentUrl();
        assertEquals(expectedUrl, Driver.getDriver().getCurrentUrl());

        assertTrue(n11Page.productList.isDisplayed());

    }
}
