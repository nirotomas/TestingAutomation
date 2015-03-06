package com.globant.training.tomas_niro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Post1 {

	@FindBy(xpath = ".//*[@id='post-41']/header/div/a/time")
	private WebElement post_time;

	@FindBy(xpath=".//*[@id='access']/div[3]/ul/li[1]/a")
	private WebElement home;
	
	public String getPostTime() {
		return post_time.getText();
	}
	
	public void goHome(){
		home.click();
	}
}
