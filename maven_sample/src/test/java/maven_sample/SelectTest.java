package maven_sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import papeobject.AdoptionPage;
import papeobject.CheckAnimalAvailablePage;
import papeobject.ConfirmMsgPage;
import papeobject.ContactPage;
import papeobject.HomePage;

public class SelectTest {

	public static WebDriver driver;
	public static WebElement element;
	public static Actions action;

	public static HomePage homePage;
	public static ContactPage contactPage;
	public static ConfirmMsgPage confirmPage;
	public static AdoptionPage adoptionPage;
	public static CheckAnimalAvailablePage checkAnimal;

	public static String actualResult;
	public static String expectedResult;
	
	public static String[] dayOption={"Today","First day of the next week","First day of the next month"};
	
	public static void main(String[] args) throws InterruptedException {
		
		// Prerequisite
		driver = new FirefoxDriver();
		homePage = new HomePage(driver);
		confirmPage = new ConfirmMsgPage(driver);
		contactPage = new ContactPage(driver);
		adoptionPage = new AdoptionPage(driver);
		checkAnimal = new CheckAnimalAvailablePage(driver);
		
		driver.get("http://thetestroom.com/webapp/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// 1-Goto Adoption-Page
		homePage.navigateToAdoptionPage();

		// 2-Select Day Option
		for(int i=0;i<dayOption.length;i++){
			adoptionPage.selectDay(dayOption[i]);
			Thread.sleep(3000);
		}		
		
		// 3-Close Browser
		driver.quit();
		
	}

}
