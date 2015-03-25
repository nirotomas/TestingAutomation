package tomas_niro.training.globant.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Results {

	public void verifyResults(WebDriver driver) {
		
		Assert.assertEquals(driver.findElement(By.className("departLocation")).getText(), "Las Vegas, NV");
		Assert.assertEquals(driver.getTitle(), "www.cheaptickets.com - Flight Results");
		Assert.assertEquals(driver.findElement(By.id("preMatrix")).findElement(By.className("airResultsMatrixMod ")).findElement(By.className("airLowestPrice")).findElement(By.tagName("h2")).getText(), "CHEAPEST PRICE");
		Assert.assertEquals(driver.findElement(By.id("rail")).findElement(By.tagName("div")).findElement(By.tagName("h2")).getText(), "Refine Results");
		Assert.assertNotEquals(driver.getCurrentUrl(),"http://www.cheaptickets.com/cheap-flights/");
	}

	public void sortByPrice(WebDriver driver) {
		 driver.findElement(By.id("main")).findElement(By.className("airResultSetHeaderMod ")).findElement(By.className("bidirectionalSort")).findElement(By.className("dropDown")).findElement(By.className("actionIcon")).click();
	}

	public void selectFirst(WebDriver driver) {
		driver.findElement(By.id("main")).findElement(By.cssSelector("a.buttonLink.link")).click();
	}

}
