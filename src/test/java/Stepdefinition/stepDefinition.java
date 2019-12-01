package Stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import resources.base;

import org.junit.runner.RunWith;
import org.testng.Assert;

import Pageobjects.Landingpage;
import Pageobjects.Loginpage;
import Pageobjects.portalHomepage;

@RunWith(Cucumber.class)
public class stepDefinition extends base {

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	driver = initializeDriver();
    }
  
    @When("^user enters (.+) and (.+) ans logs in$")
    public void user_enters_and_ans_logs_in(String username, String password) throws Throwable {
Loginpage lp = new Loginpage(driver);
		
		lp.getemail().sendKeys(username);
		lp.getpassword().sendKeys(password);
		lp.getsubmit().click();
    }

    @Then("^verify that user is successfully logged$")
    public void verify_that_user_is_successfully_logged() throws Throwable {
       
    	portalHomepage p = new portalHomepage(driver);
    	
    	Assert.assertTrue(p.getSearchBox().isDisplayed());
    	
    	
    }

   
    
    @And("^navigate to \"([^\"]*)\" $")
    public void navigate_to_something(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }
    
    @Given("navigate to {string}")
    public void navigate_to(String strArg1) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
    	driver.get(strArg1);
    	//driver.manage().window().maximize();

//Thread.sleep(4000);
    }
    

    @And("^Click on login link in home page to land on secure sign on page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_on_page() throws Throwable {
Landingpage lanep = new Landingpage(driver);

if(lanep.getPopupsize()>0)
{

lanep.getPopup().click();
}

//Thread.sleep(4000);
		lanep.getLogin().click();
		driver.manage().window().maximize();
    }
    
    @And("^close browsers$")
    public void close_browsers() throws Throwable {
       driver.quit();
    }


}