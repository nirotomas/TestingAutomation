package tomas_niro.training.globant.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Booking {

	@FindBy(xpath="html/body/div[7]/div[2]/div/form/div[2]/div/div/div[3]/div[2]/div[1]/div/div[1]/dl/dd[2]")
	private WebElement returnDate;
	
	@FindBy(xpath="html/body/div[7]/div[2]/div/form/div[2]/div/div/div[3]/div[2]/div[1]/div/div[3]")
	private WebElement to_from;
	
	public void verifyTripDetail(WebDriver driver){
	
		Assert.assertEquals(driver.findElement(By.className("contentText")).findElement(By.tagName("strong")).getText(), "Spirit Airlines");
		Assert.assertEquals(driver.findElement(By.className("inlineTerm")).findElement(By.tagName("dd")).getText(), "Wed, Mar 25, 2015");
		Assert.assertEquals(returnDate.getText(), "Thu, Mar 26, 2015");
		Assert.assertEquals(driver.findElement(By.className("flightOriginDestination")).getText(), "Las Vegas (LAS) > Los Angeles (LAX)");
		Assert.assertEquals(to_from.getText(), "Los Angeles (LAX) > Las Vegas (LAS)");
	
	}
	
	public void submit(WebDriver driver){
		driver.findElement(By.className("continueButton")).findElement(By.cssSelector("div.submit.button-primary.button-small")).findElement(By.tagName("input")).click();
	}

	public void goTravelerInfo(WebDriver driver){
		driver.findElement(By.cssSelector("input.buttons-primary.buttons-large")).click();
	}
}
