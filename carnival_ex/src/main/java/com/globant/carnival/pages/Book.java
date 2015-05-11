package com.globant.carnival.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Book {
	
	@FindBy(xpath=".//*[@id='results_container']/div") 
	private List<WebElement> cards = new ArrayList<WebElement>(); 
	
	public void go(WebDriver driver) {
		driver.get("http://www.carnival.com/BookingEngine/cruise-search/");
	}
	public List<WebElement> getCards(){
		return cards;
	}
	public void printCardPrice(WebDriver driver){
		List<WebElement> prices = driver.findElements(By.xpath(".//*[@class='centered']/div/strong"));
		for (int i = 0; i < prices.size(); i++){
			System.out.println("\t"+prices.get(i).getText());
		}
	}
	public void printCardTitle(WebDriver driver) {
		List<WebElement> cardsTitle = driver.findElements(By.className("itin-select"));
		for (int i = 0; i < cardsTitle.size(); i++) {
			System.out.println("\t "+cardsTitle.get(i).getText());
		}
		System.out.println();
	}
	public void dateCard(WebDriver driver) {
		driver.findElement(By.xpath(".//*[@class='right-side']/a")).click();
	}
}
