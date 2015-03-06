package com.globant.training.tomas_niro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs {
	
	@FindBy(id="cntctfrm_contact_name")
	private WebElement name;
	
	@FindBy(id="cntctfrm_contact_email")
	private WebElement email;
	
	@FindBy(id="cntctfrm_contact_subject")
	private WebElement subject;
	
	@FindBy(id="cntctfrm_contact_message")
	private WebElement message;
	
	@FindBy(xpath=".//*[@id='cntctfrm_contact_form']/div[9]/input[4]")
	private WebElement submit;
	
	public void sendForm(String name, String email, String subject, String message){
		this.name.sendKeys(name);
		this.email.sendKeys(email);
		this.subject.sendKeys(subject);
		this.message.sendKeys(message);
		submit.click();
	}
	
	public void sendForm(String name, String subject, String message){
		this.name.sendKeys(name);
		this.subject.sendKeys(subject);
		this.message.sendKeys(message);
		submit.click();
	}
	
	public void go(WebDriver driver) {
		driver.get("http://10.28.148.127/wordpress/sample-page/");
	}

}
