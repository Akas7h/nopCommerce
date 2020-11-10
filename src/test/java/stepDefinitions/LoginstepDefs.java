package stepDefinitions;

import java.io.FileInputStream;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import context.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utilities.Alert_util;

public class LoginstepDefs{
	
	//public WebDriver driver;
	public BaseClass baseclass ;
	//public LoginPage lp ;
	//WebDriver drivr;
	
	public LoginstepDefs(BaseClass baseclass) {
		// TODO Auto-generated constructor stub
		this.baseclass = baseclass;
	}
	
	
	@Before
	public void setup() throws Exception {
		
		Properties configprop = new Properties();
		
		FileInputStream configpropfile = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		
		configprop.load(configpropfile);
		
		String br = configprop.getProperty("browser");
		String chromePath =configprop.getProperty("chromepath");
		System.out.println(chromePath);
		
		if(br.contains("chrome")) {
		
		//System.setProperty("webdriver.chrome.driver",configprop.getProperty("chromepath"));
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\"+chromePath);
		WebDriver drivr = new ChromeDriver();
		
        baseclass.setDriver(drivr);
		
		baseclass.initializePageObjectClasses(drivr);
		
		}
		
		
	}
	
	
	@Given("User launch Chrome Browser")
	public void user_launch_Chrome_Browser() {
		
		Assert.assertTrue("Chrome Browser is initialted",true);
		
		
	    
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String string) {
		baseclass.getDriver().get(string);
	    
	}

	@When("user enters Email as {string} and password {string}")
	public void user_enters_Email_as_and_password(String string, String string2) {
		
		baseclass.getLoginPageObject().setEmail(string);
		baseclass.getLoginPageObject().setPassword(string2);
		
	    
	}

	@When("click login")
	public void click_login() {
		
		baseclass.getLoginPageObject().clickLogin();
		if(Alert_util.isAlertPresent(baseclass.getDriver())) {
			
			baseclass.getDriver().switchTo().alert().accept();
			baseclass.getDriver().switchTo().defaultContent();
		}
	   
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		
		String pageTitle = baseclass.getDriver().getTitle();
		if(baseclass.getDriver().getPageSource().contains("was unsuccessful.")) {
			
			baseclass.getDriver().close();	
		  Thread.sleep(2000);
		 Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(title,pageTitle);
		}
	}

	@When("user clicks on Logout link")
	public void user_clicks_on_Logout_link() throws InterruptedException {
		
		baseclass.getLoginPageObject().clickLogOut();
		Thread.sleep(2000);
	   
	}

	

	/*@Then("close the browser")
	public void close_the_browser() {
		baseclass.getDriver().close();
	}
  */
	@After
	public void tearDown() {
		
		baseclass.getDriver().close();
	}
	
	
}
