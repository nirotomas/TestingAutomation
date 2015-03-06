package com.globant.training.tomas_niro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Post2 {

	@FindBy(xpath=".//*[@id='post-39']/header/div/a/time")
	private WebElement post_time;
	
	public String getPostTime(){
		return post_time.getText();
	}
	
}
