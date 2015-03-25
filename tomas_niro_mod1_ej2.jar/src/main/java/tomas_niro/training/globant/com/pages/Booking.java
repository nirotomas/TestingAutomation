package tomas_niro.training.globant.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Booking {
	
	public void verifyTripDetail(WebDriver driver){
		
		Assert.assertEquals(driver.findElement(By.id("preMain")).getText(),"Los Angeles Trip Details: Flight");
		Assert.assertEquals(driver.getTitle(), "www.cheaptickets.com - Trip details");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.heading.withLink")).getText(), "Trip Information");
		Assert.assertEquals(driver.findElement(By.className("flightOriginDestination")).getText(), "Las Vegas (LAS) > Los Angeles (LAX)");
		Assert.assertEquals(driver.findElements(By.className("flightOriginDestination")).get(1).getText(), "Los Angeles (LAX) > Las Vegas (LAS)");
	
	}
	
	public void submit(WebDriver driver){
		driver.findElement(By.className("continueButton")).findElement(By.cssSelector("div.submit.button-primary.button-small")).findElement(By.tagName("input")).click();
	}

	public void goTravelerInfo(WebDriver driver){
		driver.findElement(By.cssSelector("input.buttons-primary.buttons-large")).click();
	}
}
