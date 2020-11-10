package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import context.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCustomerstepdef{
	
	public BaseClass baseclass;
	
	public AddCustomerstepdef(BaseClass baseclass) {
		// TODO Auto-generated constructor stub
		this.baseclass = baseclass;
	}
	
	
	@Then("User can view Dashboard page")
	public void user_can_view_Dashboard_page() {
	    
		String actul = baseclass.getAddcustomerPageObject().getPageTitle();
		
		Assert.assertEquals("We are inside Dashboard page","Dashboard / nopCommerce administration", actul);
		
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() throws InterruptedException {
		
		baseclass.getAddcustomerPageObject().clickOnCustomersMenu();
		Thread.sleep(5000);
	   
	}

	@When("click on customers menu item")
	public void click_on_customers_menu_item() {
		
		baseclass.getAddcustomerPageObject().clickOnCustomersMenuItem();
	   
	}

	@When("click on Add new button item")
	public void click_on_Add_new_button_item() {
		
		baseclass.getAddcustomerPageObject().clickOnAddnew();
	    
	}

	@Then("User can view Add a new customer page")
	public void user_can_view_Add_a_new_customer_page() {
	    
		String customerpageTitle = baseclass.getAddcustomerPageObject().getPageTitle();
		
		Assert.assertEquals("We are inside Add a new customer page","Add a new customer / nopCommerce administration", customerpageTitle);
	}

	@When("user enters customer info")
	public void user_enters_customer_info() throws InterruptedException {
		
	    String email = baseclass.randomEmailString() ;
	    baseclass.getAddcustomerPageObject().setEmail(email);
	    baseclass.getAddcustomerPageObject().setPassword("test123");
	    baseclass.getAddcustomerPageObject().setCustomerRoles("Guests");
	    baseclass.getAddcustomerPageObject().setManagerOfVendor("Vendor 2");
	    baseclass.getAddcustomerPageObject().setGender("Male");
	    baseclass.getAddcustomerPageObject().setFirstName("Akash");
	    baseclass.getAddcustomerPageObject().setLastName("Bhattacharjee");
	    baseclass.getAddcustomerPageObject().setDob("5/8/1991");
	    baseclass.getAddcustomerPageObject().setCompanyName("AkiQA");
	    baseclass.getAddcustomerPageObject().setAdminContent("Testing purpose");
	    
	}

	@When("click on save button")
	public void click_on_save_button() {
		
		 baseclass.getAddcustomerPageObject().clickOnSave();
	    
	}

	@Then("user can view confirm message {string}")
	public void user_can_view_confirm_message(String string) {
	   
		Assert.assertTrue(baseclass.getDriver().findElement(By.tagName("body")).getText().contains(string));
		
	}
	

@When("Enter customer email")
public void enter_customer_email() {
    // Write code here that turns the phrase above into concrete actions
     baseclass.getSearchcustomerPageObject().setEmail("victoria_victoria@nopCommerce.com");
}

@When("click on search button")
public void click_on_search_button() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	baseclass.getSearchcustomerPageObject().clickSearch();
	//Thread.sleep(5000);
}

@Then("user should found Email in the search table")
public void user_should_found_Email_in_the_search_table() {
    // Write code here that turns the phrase above into concrete actions
	boolean status = baseclass.getSearchcustomerPageObject().searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	Assert.assertEquals(true,status);
	
}



/*@Then("close browser")
public void close_browser() {
    // Write code here that turns the phrase above into concrete actions
    baseclass.getDriver().close();
}*/

@When("Enter customer FirstName")
public void enter_customer_FirstName() {
    
	baseclass.getSearchcustomerPageObject().setFirstName("Victoria");
}

@When("Enter customer LastName")
public void enter_customer_LastName() {
 
	baseclass.getSearchcustomerPageObject().setLastName("Terces");
}

@Then("user should found Name in the search table")
public void user_should_found_Name_in_the_search_table() {
	
	boolean status = baseclass.getSearchcustomerPageObject().searchCustomerByName("Victoria Terces");
	Assert.assertEquals(true,status);
}


}
