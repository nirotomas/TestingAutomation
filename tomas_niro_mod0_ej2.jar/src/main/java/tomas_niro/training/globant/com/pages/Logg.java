package tomas_niro.training.globant.com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logg {

	public void go(WebDriver driver) {
		driver.get("https://www.cheaptickets.com/account/login?destinationUrl=%2F");
	}

	public void logIn(WebDriver driver, String email, String pssw) {
		driver.findElement(By.name("models['userName'].userName")).sendKeys(email);
		driver.findElement(By.name("models['loginPasswordInput'].password")).sendKeys(pssw);
		driver.findElement(By.name("_eventId_submit")).click();
	}

	public String welcome(WebDriver driver) {
		return driver.findElement(By.className("welcomeText")).getText();
	}

	public void signOut(WebDriver driver) {
		driver.findElement(By.className("signOutLink")).findElement(By.className("link")).click();
	}
	
	public String signedOut(WebDriver driver){
		return driver.findElement(By.id("preMain")).findElement(By.tagName("h1")).getText();
	}
	
}
