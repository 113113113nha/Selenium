package papeobject;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AbstractPage {

	protected WebDriver driver;
	protected String URL = "http://thetestroom.com/webapp/";
	protected Actions action;
	
	// Log4j
//	public static final Logger log4j = Logger.getRootLogger();
	public static final Logger log4j = Logger.getLogger("toLogger");

	// Constructor
	public AbstractPage(WebDriver driver) {
		PropertyConfigurator.configure("properties/log4j.properties");
//		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Log4JLogger");
		this.driver = driver;
	}

	// navigateToHomepage
	public HomePage navigateToWebApp() {
		driver.get(URL);
		return new HomePage(driver);
	}

}
