package context;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;



public class BaseClass {
	
	private WebDriver driver;
	private LoginPage lp;
	private AddcustomerPage addCust;
	private SearchCustomerPage searchCust;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage getLoginPageObject() {
		
		return lp;
	}
	
    public AddcustomerPage getAddcustomerPageObject() {
		
		return addCust;
	}
    
 public SearchCustomerPage getSearchcustomerPageObject() {
		
		return searchCust;
	}
    public void initializePageObjectClasses(WebDriver driver) {
    	lp = new LoginPage(driver);
    	addCust = new AddcustomerPage(driver);
    	searchCust= new SearchCustomerPage(driver);
		
	}
	
	
	
	public String randomEmailString() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(7);
		return generatedString+"@gmail.com" ;
	}
	
	public static String randomPassword() {
		
		String randomPass = RandomStringUtils.randomNumeric(8);
		return randomPass+"5eR" ;
	}

}
