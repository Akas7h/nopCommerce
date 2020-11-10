package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import context.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCustomerstepdef{
	
	public BaseClass baseclass;
	//Scenario scn ;
	public AddCustomerstepdef(BaseClass baseclass) {
		// TODO Auto-generated constructor stub
		this.baseclass = baseclass;
		//this.scn = sk ;
	}
	
	
	@Then("User can view Dashboard page")
	public void user_can_view_Dashboard_page() throws InterruptedException {
	    Thread.sleep(5000);
		String actul = baseclass.getAddcustomerPageObject().getPageTitle();
		
		Assert.assertEquals("We are inside Dashboard page","Dashboard / nopCommerce administration", actul);
		System.out.println("Scenario executed");
		baseclass.getScenario().write("We are inside DashBoard page");
		//scn.write("We are inside DashBoard page");
		System.out.println("Scenario Unexecuted");
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() throws InterruptedException {
		
		baseclass.getAddcustomerPageObject().clickOnCustomersMenu();
		//scn.write("Customer manu is clicked");
		baseclass.getScenario().write("Customer manu is clicked");
		Thread.sleep(5000);
	    
	}

	@When("click on customers menu item")
	public void click_on_customers_menu_item() {
		
		baseclass.getAddcustomerPageObject().clickOnCustomersMenuItem();
		//scn.write("Customer manu item is clicked");
		baseclass.getScenario().write("Customer manu item is clicked");
	}

	@When("click on Add new button item")
	public void click_on_Add_new_button_item() {
		
		baseclass.getAddcustomerPageObject().clickOnAddnew();
		//scn.write("Add new button item is clicked");
		baseclass.getScenario().write("Add new button item is clicked");
	}

	@Then("User can view Add a new customer page")
	public void user_can_view_Add_a_new_customer_page() {
	    
		String customerpageTitle = baseclass.getAddcustomerPageObject().getPageTitle();
		baseclass.getScenario().write("Entered inside Add a new customer page");
		//scn.write("Entered inside Add a new customer page");
		Assert.assertEquals("We are inside Add a new customer page","Add a new customer / nopCommerce administration", customerpageTitle);
	}

	@When("user enters customer info")
	public void user_enters_customer_info() throws InterruptedException {
		
	    String email = baseclass.randomEmailString() ;
	   //scn.write("Email entered is "+email);
	    
	    baseclass.getAddcustomerPageObject().setEmail(email);
	  // scn.write("Email entered is "+email);
	    baseclass.getAddcustomerPageObject().setPassword("test123");
	    
	    baseclass.getAddcustomerPageObject().setCustomerRoles("Guests");
	   // scn.write("Customer role is entered");
	    baseclass.getAddcustomerPageObject().setManagerOfVendor("Vendor 2");
	    baseclass.getAddcustomerPageObject().setGender("Male");
	    baseclass.getAddcustomerPageObject().setFirstName("Akash");
	    baseclass.getAddcustomerPageObject().setLastName("Bhattacharjee");
	    baseclass.getAddcustomerPageObject().setDob("5/8/1991");
	    baseclass.getAddcustomerPageObject().setCompanyName("AkiQA");
	    baseclass.getAddcustomerPageObject().setAdminContent("Testing purpose");
	   //scn.write("Customer info is entered");
	    baseclass.getScenario().write("Customer info is entered");
	}

	@When("click on save button")
	public void click_on_save_button() {
		
		 baseclass.getAddcustomerPageObject().clickOnSave();
		 //scn.write("Save button clicked");
		 baseclass.getScenario().write("Save button clicked");
	}

	@Then("user can view confirm message {string}")
	public void user_can_view_confirm_message(String string) {
	   
		Assert.assertTrue(baseclass.getDriver().findElement(By.tagName("body")).getText().contains(string));
		//scn.write("Message visible is  "+string);
		baseclass.getScenario().write("Message visible is  "+string);
	}
	

@When("Enter customer email")
public void enter_customer_email() {
    // Write code here that turns the phrase above into concrete actions
     baseclass.getSearchcustomerPageObject().setEmail("victoria_victoria@nopCommerce.com");
    //scn.write("Customer email entered");
}

@When("click on search button")
public void click_on_search_button() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	baseclass.getSearchcustomerPageObject().clickSearch();
	//Thread.sleep(5000);
	//scn.write("Search button is clicked");
	//baseclass.getScenario().write("Message visible is  "+string);
}

@Then("user should found Email in the search table")
public void user_should_found_Email_in_the_search_table() {
    // Write code here that turns the phrase above into concrete actions
	boolean status = baseclass.getSearchcustomerPageObject().searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	Assert.assertEquals(true,status);
	//scn.write("Email found in search table");
	baseclass.getScenario().write("Email found in search table");
}



/*@Then("close browser")
public void close_browser() {
    // Write code here that turns the phrase above into concrete actions
    baseclass.getDriver().close();
}*/

@When("Enter customer FirstName")
public void enter_customer_FirstName() {
    
	baseclass.getSearchcustomerPageObject().setFirstName("Victoria");
	//scn.write("First name entered");
	baseclass.getScenario().write("First name entered");
}

@When("Enter customer LastName")
public void enter_customer_LastName() {
 
	baseclass.getSearchcustomerPageObject().setLastName("Terces");
	//scn.write("Last name entered");
	
}

@Then("user should found Name in the search table")
public void user_should_found_Name_in_the_search_table() {
	
	boolean status = baseclass.getSearchcustomerPageObject().searchCustomerByName("Victoria Terces");
	Assert.assertEquals(true,status);
	//scn.write("Name found in search table");
	baseclass.getScenario().write("Name found in search table");
}


}
