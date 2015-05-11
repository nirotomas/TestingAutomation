package com.globant.carnival.pages;

import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogIn {

	@FindBy(id="username")
    private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login")
	private WebElement submit;
	
	public void go(WebDriver driver ){
    	driver.get("https://secure.carnival.com/BookedGuest/guestmanagement/mycarnival/logon?returnUrl=http%3A%2F%2Fwww.carnival.com%2F");
	}
    public void writeUser(String user){
    	username.clear();
    	username.sendKeys(user);
    }
    public void writePassword(String pass){
    	password.clear();
    	password.sendKeys(pass);
    }
    public void submit(){
    	submit.click();
    }
    public void verifyLog(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals("Login was unsuccessful. Please correct the errors and try again.", 
							driver.findElement(By.xpath(".//*[@id='loginForm']/div/div[2]/span")).getText());
    }
    
}
