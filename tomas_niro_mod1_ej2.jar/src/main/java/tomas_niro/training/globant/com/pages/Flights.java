package tomas_niro.training.globant.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Flights {

	public void go(WebDriver driver) {
		driver.get("http://www.cheaptickets.com/cheap-flights/");
	}
	
	public void inputFromTo(WebDriver driver,String from, String to){
		driver.findElement(By.name("ar.rt.leaveSlice.orig.key")).sendKeys(from); 
		driver.findElement(By.name("ar.rt.leaveSlice.dest.key")).sendKeys(to);
		//input_to.sendKeys(to);
	}
	
	public void submit(WebDriver driver){
		driver.findElement(By.className("searchFormForm")).findElement(By.name("search")).click();
	}
	
	public void pickDate(WebDriver driver,String leaveDate,String returnDate){
		driver.findElement(By.name("ar.rt.leaveSlice.date")).sendKeys(leaveDate);
		driver.findElement(By.name("ar.rt.returnSlice.date")).sendKeys(returnDate);
	}
	
	public void flight_hotel(WebDriver driver,String leaveDate,String returnDate,String from, String to){
		driver.findElement(By.name("aph.leaveSlice.date")).sendKeys(leaveDate);
		driver.findElement(By.name("aph.returnSlice.date")).sendKeys(returnDate);
		driver.findElement(By.name("aph.leaveSlice.orig.key")).sendKeys(from); 
		driver.findElement(By.name("aph.leaveSlice.dest.key")).sendKeys(to);
		submit(driver);
	}

	public void hotel_flight_rsts(WebDriver driver) throws InterruptedException {

		Assert.assertNotNull(driver.findElements(By.cssSelector("div.pkgResultsCard.pkgResultsHotelCard")),"none resutlt Card found");
		Assert.assertEquals(driver.findElement(By.className("pkgSummaryInfo")).getText(), "Flight tickets: 2\nHotel rooms: 1\nNights: 1","package Summary not match"); 
		Assert.assertEquals(driver.findElement(By.className("pkgResultsChangeSearchMod ")).findElement(By.className("flightLocationCodes")).getText(), "Las Vegas, NV (LAS)","Flight location not match");
		Assert.assertEquals(driver.findElements(By.className("pkgResultsChangeSearchMod ")).get(0).findElements(By.className("flightLocationCodes")).get(1).getText(), "Los Angeles, CA (LAX)");
		Assert.assertEquals(driver.getTitle(), "www.cheaptickets.com - Vacation search results");

		//sortBy ReviewerScore
		driver.findElement(By.className("pkgResultsSort")).
		findElement(By.className("bidirectionalSort")).
		findElement(By.tagName("div")).findElement(By.tagName("div")).click();
		driver.findElement(By.className("content")).
		findElement(By.tagName("ul")).
		findElements(By.tagName("li")).
		get(5).
		findElement(By.className("link")).
		click();
		
		Thread.sleep(20 * 1000);
		//star Rating 4 and up
		driver.findElement(By.className("rating")).findElement(By.className("link")).click();
		Thread.sleep(20 * 1000);

		//Select First Result
		driver.findElement(By.className("pkgResultsMod ")).findElement(By.tagName("div")).
		findElement(By.tagName("div")).findElement(By.cssSelector("div.IM_right_column.IM_show_price")).
		findElement(By.className("IM_ssn_button_red")).findElement(By.tagName("a")).click();
		//select first Flight result
		Thread.sleep(15 * 1000);

		driver.findElement(By.cssSelector("div.pkgResultsCard.pkgResultsAirCard.airResultsCard.pkgAirResultsCard")).
		findElement(By.className("container")).findElement(By.className("main")).findElement(By.className("secondary")).
		findElement(By.cssSelector("div.linkAsButton.button-primary.button-medium.selectFlight")).
		findElement(By.cssSelector("a.buttonLink.link")).click();
		
		Thread.sleep(20 * 1000);

	}
	
}
