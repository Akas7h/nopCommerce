package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {

	public WebDriver ldriver;
	public WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver = rdriver;
		PageFactory.initElements(ldriver,this);
		waithelper = new WaitHelper(rdriver);
	}
	
	@FindBy(xpath="//input[@name='SearchEmail']")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='SearchFirstName']")
    @CacheLookup
    WebElement txtFirstName;
	
	//SearchLastName
	@FindBy(xpath="//input[@name='SearchLastName']")
    @CacheLookup
    WebElement txtLastName;
	
	@FindBy(xpath="//input[@name='SearchCompany']")
    @CacheLookup
    WebElement txtCompanyName;
	
	@FindBy(xpath="//input[@name='SearchIpAddress']")
    @CacheLookup
    WebElement txtIpAddress;
	
	@FindBy(id="SearchMonthOfBirth")
	@CacheLookup
	WebElement drpdobMonth;
	

	@FindBy(id="DayOfBirth")
	@CacheLookup
	WebElement drpdayOfBirth;
	
	//$x("//*[@id='SelectedCustomerRoleIds']")
	@FindBy(xpath="//*[@id='SelectedCustomerRoleIds']")
	@CacheLookup
	WebElement txtCustomerRoles;
	
	@FindBy(xpath="//*[@id='search-customers']")
	@CacheLookup
	WebElement searchButton;
	
	//$x("//table[@id='customers-grid']")
    @FindBy(xpath="//table[@id='customers-grid']")
    @CacheLookup
    WebElement table;
    
    @FindBy(xpath="//table[@id='customers-grid']/tbody/tr")
    @CacheLookup
    List<WebElement> tablerows;
    
    ////*[@id="customers-grid"]/tbody/tr[1]/td[1]
    @FindBy(xpath="//table[@id='customers-grid']/tbody/tr/td")
    @CacheLookup
    List<WebElement> tablecolumns;
    
    public void setEmail(String email) {
    	waithelper.waitForElement(txtEmail,30);
    	txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setFirstName(String fname) {
        
		waithelper.waitForElement(txtFirstName,30);
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
        
		waithelper.waitForElement(txtLastName,30);
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}

	public void clickSearch() {
		searchButton.click();
		//waithelper.waitForElement(table,50);
	}

	public int getNoOfRows() {
		return (tablerows.size());
	}

	public int getNoOfColumns() {
		return (tablecolumns.size());
	} 
    
    

	public boolean searchCustomerByEmail(String email) {
		//wait.until(ExpectedConditions.textToBePresentInElement(element, "text"));
		waithelper.waitForTextElement(table,50,email);
		boolean flag = false;

		for (int i = 1; i <= getNoOfRows(); i++) {
			String emailid = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]"))
					.getText();

					
			
			System.out.println(emailid);

			if (emailid.equals(email)) {
				flag = true;
				break;
			}
		}

		return flag;

	}

	public boolean searchCustomerByName(String Name) {
		
		waithelper.waitForTextElement(table,50,Name);
		boolean flag = false;

		for (int i = 1; i <= getNoOfRows(); i++) {
			String name = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]"))
					.getText();

			
			if (Name.equals(name)) {
				flag = true;
				break;
			}
		}

		return flag;

	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	
}
