package tomas_niro.training.globant.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TripDetails {

	public void verifyInfo(WebDriver driver) {
		Assert.assertEquals(driver.getTitle(), "www.cheaptickets.com - Trip details");
		Assert.assertEquals(driver.findElement(By.id("preMain")).getText(), "Los Angeles Trip Details: Flight + Hotel");
		Assert.assertEquals(driver.findElement(By.id("costItemGroup1")).getText(), "Flight + Hotel Package");
		Assert.assertEquals(driver.findElement(By.cssSelector("h4.productInfo.withLink")).getText(), "Flight\nChange flight");
		Assert.assertEquals(driver.findElement(By.cssSelector("h4.productInfo.withLink.productDivider")).getText(), "Hotel\nChange hotel");
	}

}
