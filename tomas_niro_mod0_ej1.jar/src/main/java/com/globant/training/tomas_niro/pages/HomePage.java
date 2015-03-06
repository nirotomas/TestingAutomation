package com.globant.training.tomas_niro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage {

	@FindBy(id = "site-title")
	private WebElement siteTitle;

	@FindBy(xpath = ".//*[@id='access']/div[3]/ul/li[2]/a")
	private WebElement contactBtn;

	@FindBy(xpath = ".//*[@id='site-title']/span/a")
	private WebElement homeLink;
	
	@FindBy(xpath = ".//*[@id='post-39']/header/h1/a")
	private WebElement softTestingLink;
	
	@FindBy(xpath=".//*[@id='post-41']/header/h1/a")
	private WebElement its_used_for;

	@FindBy(id = "s")
	private WebElement searchInput;

	@FindBy(id = "searchsubmit")
	private WebElement search_submit;

	@FindBy(xpath=".//*[@id='post-39']/header/div/a/time")
	private WebElement post_time;
	
	@FindBy(xpath=".//*[@id='post-41']/header/div/a/time")
	private WebElement post_time1;

	@FindBy(id="prev")//.//*[@id='prev']/a
	private WebElement calendarPost;
	
	public void go(WebDriver driver) {
		driver.get("http://10.28.148.127/wordpress/");
	}

	public boolean search(String query, WebDriver driver) {
		searchInput.sendKeys(query);
		search_submit.submit();
		List<WebElement> lista = driver.findElements(By.id("post-0"));
		if(lista != null)
			return true;
		else
			return false;
	}

	public String getTitle() {
		return siteTitle.getText();
	}

	public void goContact() {
		contactBtn.click();
	}

	public void goLink(String post) {
		if(post.equals("post1"))
			softTestingLink.click();
		else if(post.equals("post2"))
			its_used_for.click();
	}

	public void goHome() {
		homeLink.click();
	}
	
	public void postOnMonth(){
		calendarPost.click();
	}
	
	public String getPostTime(){
		return "Its used for "+post_time.getText()+" What software testin is "+post_time1.getText();
	}
}
