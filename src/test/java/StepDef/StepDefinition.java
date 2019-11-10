package StepDef;

import CompSelPro.Base;
import PageObject.CheckOutPage;
import PageObject.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;


@RunWith(Cucumber.class)
public class StepDefinition {

    HomePage h;
    CheckOutPage cp = new CheckOutPage();

    @Given("^User will navigate to website$")
    public void user_will_navigate_to_website() throws Throwable {

        Base.getDriver();

    }

    @When("^User searches for \"([^\"]*)\"$")
    public void user_searches_for_something(String strArg1) throws Throwable {
        h = new HomePage();
        h.getSearch().sendKeys(strArg1);
        Thread.sleep(2000);

    }

    @Then("^\"([^\"]*)\" result is displayed$")
    public void something_result_is_displayed(String strArg1) throws Throwable {
        Assert.assertTrue(h.getProductName().getText().contains(strArg1));
    }

    @When("^User searches for \"([^\"]*)\" Vegetable$")
    public void user_searches_for_Vegetable(String arg1) throws Throwable {
        h = new HomePage();
        h.getSearch().sendKeys(arg1);
    }

    @When("^Added items to the cart$")
    public void added_items_to_the_cart() throws Throwable {
        HomePage h = PageFactory.initElements(Base.driver, HomePage.class);
        h.increase();
        h.setToCart();

    }

    @When("^User proceed to the checkout page$")
    public void user_proceed_to_the_checkout_page() throws Throwable {
        cp.getImage().click();
        cp.getProceedToCheckout().click();
    }

    @Then("^Verify selected \"([^\"]*)\" items are displayed in the checkout page$")
    public void verify_selected_items_are_displayed_in_the_checkout_page(String arg1) throws Throwable {

    }

    @When("^user added more than one item to the cart$")
    public void user_added_more_than_one_item_to_the_cart() throws Throwable {
      String[] itemsNeeded ={"Beans - 1 Kg", "Beetroot - 1 Kg", "Brocolli - 1 Kg"};
      Thread.sleep(3000);
        List<WebElement> products = h.getSelects();
        for(int i=0; i< products.size(); i++){
            String name = products.get(i).getText();
            List itemsNeededList = Arrays.asList(itemsNeeded);
                if(itemsNeededList.contains(name)){
                    h.addCartLists().get(i).click();
            }
        }
    }

    @Then("^user proceed to the CheckOut Page$")
    public void user_proceed_to_the_CheckOut_Page() throws Throwable {

    }

    @Then("^Verify selected items are displayed in the checkout page$")
    public void verify_selected_items_are_displayed_in_the_checkout_page() throws Throwable {

    }


}