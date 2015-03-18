package tomas_niro.training.globant.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelerInfo {

	public void fillInfo(WebDriver driver, String first,String last,String phone,String email,boolean logged){

		driver.findElement(By.name("models['travelersInput'].travelers[0].phoneNumber.phoneNumber")).sendKeys(phone);
		//if you're not logged in the field below is needed
		if(!logged){
			driver.findElement(By.name("models['travelersInput'].travelers[0].name.firstName")).sendKeys(first);
			driver.findElement(By.name("models['travelersInput'].travelers[0].name.lastName")).sendKeys(last);
			driver.findElement(By.name("models['bookingInput'].email.emailAddress")).sendKeys(email);
		}

		//month
		driver.findElement(By.className("genderDateOfBirthInput")).findElement(By.cssSelector("fieldset.dateOfBirth.inlineInputGroup.required ")).
		findElements(By.tagName("label")).get(0).
		findElement(By.className("button")).click();
		driver.findElement(By.className("custom-select-list")).findElement(By.tagName("ul")).findElements(By.tagName("li")).get(3).click();
		
		//day
		driver.findElement(By.className("genderDateOfBirthInput")).findElement(By.cssSelector("fieldset.dateOfBirth.inlineInputGroup.required ")).
		findElements(By.tagName("label")).get(1).
		findElement(By.className("button")).click();
		driver.findElement(By.className("custom-select-list")).findElement(By.tagName("ul")).findElements(By.tagName("li")).get(3).click();
		
		//year
		driver.findElement(By.className("genderDateOfBirthInput")).findElement(By.cssSelector("fieldset.dateOfBirth.inlineInputGroup.required ")).
		findElements(By.tagName("label")).get(2).
		findElement(By.className("button")).click();
		driver.findElement(By.className("custom-select-list")).findElement(By.tagName("ul")).findElements(By.tagName("li")).get(25).click();
		
		//gender
		driver.findElement(By.className("genderDateOfBirthInput")).findElement(By.className("button")).click();
		driver.findElement(By.className("custom-select-list")).findElement(By.tagName("ul")).findElements(By.tagName("li")).get(2).click();
		
		//enssurence options
		driver.findElement(By.name("models['addInsurance'].insProductGroupContentRequired[0].selectedProductIndex")).click();


	}
	
	public void continuar(WebDriver driver, boolean logged){
		if(!logged){
			driver.findElement(By.cssSelector("input.active")).click();
			return;
		}
		driver.findElement(By.cssSelector("div.submit.button-primary.button-small")).findElement(By.tagName("input")).click();
	}
	
}
