package utilities;

import org.openqa.selenium.WebDriver;

public class PageTitle_util {
	
	
	
	public static String getPageTitle(WebDriver webdriver) {
		
		return webdriver.getTitle();
		
	}

}
