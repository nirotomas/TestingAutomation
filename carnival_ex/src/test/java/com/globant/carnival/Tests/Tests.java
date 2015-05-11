package com.globant.carnival.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.globant.carnival.pages.Book;
import com.globant.carnival.pages.LogIn;

public class Tests{
	
	WebDriver driver=new FirefoxDriver();


	public void TC1(){
		LogIn logPage = PageFactory.initElements(driver, LogIn.class);
		logPage.go(driver);
		logPage.writeUser("tniro");
		logPage.writePassword("password1");
		logPage.submit();
		logPage.verifyLog(driver);
	}
	@Test
	public void TC2(){
		Book book = PageFactory.initElements(driver, Book.class);
		book.go(driver);
		System.out.println("Total cards: "+book.getCards().size()+"\n");
		System.out.println("CardPrices: ");
		book.printCardPrice(driver);
		System.out.println("\nCards Title: ");
		book.printCardTitle(driver);
		book.dateCard(driver);
		//book.verifyDateCard(driver);
	}
	
}
