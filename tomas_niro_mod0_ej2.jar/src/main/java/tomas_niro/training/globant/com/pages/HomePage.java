package tomas_niro.training.globant.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



/**
 * @author tomas.niro
 *
 */
public class HomePage {

	@FindBy(xpath=".//*[@id='headerStandard']/div[1]/div[1]/ul[1]/li[3]/a")
	private WebElement register;
	
	@FindBy(xpath="html/body/div[8]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a")
	private WebElement loggin;
	
	@FindBy(xpath=".//*[@id='headerStandard']/div[2]/ul[1]/li[6]/a/span/span")
	private WebElement flights;
	
	public void goHome(WebDriver driver){
		driver.get("http://www.cheaptickets.com/");
	}
	
	public void goRegister(){
		register.click();
	}
	
	public Logg goLogin(WebDriver driver){
		return PageFactory.initElements(driver, Logg.class); 
	}

	public Flights goFlights(WebDriver driver) {
		flights.click();
		return PageFactory.initElements(driver, Flights.class);
	}

}
