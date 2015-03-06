package com.globant.training.tomas_niro;

import java.util.Iterator;
import java.util.List;

import org.apache.bcel.verifier.Verifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globant.training.tomas_niro.pages.ContactUs;
import com.globant.training.tomas_niro.pages.HomePage;
import com.globant.training.tomas_niro.pages.Post1;
import com.globant.training.tomas_niro.pages.Post2;

public class Tests {

	WebDriver driver;

	@BeforeMethod
	public void before() {
		driver = new FirefoxDriver();
	}

	@AfterMethod
	public void after() {
		driver.quit();
	}

	/*
	 * @Test public void case1(){ HomePage homePage =
	 * PageFactory.initElements(driver, HomePage.class); homePage.go(driver);
	 * homePage.goContact(); homePage.goHome(); homePage.goLink();
	 * homePage.goHome(); homePage.search("software"); }
	 *//*
		 * @Test public void case1(){ HomePage homePage =
		 * PageFactory.initElements(driver, HomePage.class);
		 * homePage.go(driver); Assert.assertEquals(driver.getTitle(),
		 * "Automation Training | Aprender a automatizar en un solo sitio"); }
		 */
	/*
	 * @Test public void case1Man(){ HomePage homePage =
	 * PageFactory.initElements(driver, HomePage.class); homePage.go(driver);
	 * Assert.assertEquals(homePage.getTitle(),
	 * "Automation Training | Aprender a automatizar en un solo sitio"); }
	 *//*
		 * @Test public void case2(){ HomePage homePage =
		 * PageFactory.initElements(driver, HomePage.class);
		 * homePage.go(driver);
		 * Assert.assertTrue(homePage.search("software",driver
		 * ),"no hay resultados");
		 * 
		 * }
		 *//*
			 * @Test public void case3() throws InterruptedException{
			 * 
			 * String buff=""; String buff1="October 10, 2013 October 10, 2013";
			 * 
			 * HomePage homePage = PageFactory.initElements(driver,
			 * HomePage.class); homePage.go(driver); homePage.goLink("post2");
			 * 
			 * // Inicializo la pagina del primer post "Its used for" Post1
			 * post1 = PageFactory.initElements(driver, Post1.class);
			 * buff=post1.getPostTime(); post1.goHome();
			 * 
			 * homePage.goLink("post1"); // Inicializo la pagina del segundo
			 * post "sotware test" Post2 post2 =
			 * PageFactory.initElements(driver, Post2.class);
			 * buff+=" "+post2.getPostTime();
			 * 
			 * Assert.assertEquals(buff, buff1, "They are not equals"); }
			 */
	/*
	 * @Test(description="Case4") public void testForm(){ ContactUs contact =
	 * PageFactory.initElements(driver, ContactUs.class); contact.go(driver);
	 * contact.sendForm("Tomas", "tomas.niro@globant.com", "Test",
	 * "its working?"); java.util.List<WebElement> lista =
	 * driver.findElements(By.id("cntctfrm_thanks")); boolean b; if
	 * (lista.size() == 1) b=true; else b=false; Assert.assertEquals(b, true); }
	 * 
	 * @Test(description="Case 5: Fill some fields of ContactUs form page" +
	 * " then correct it and verify") public void testForm2(){
	 * //Assert.assertEquals(driver.getTitle(), "Login",
	 * "This is not the login page"); ContactUs contact =
	 * PageFactory.initElements(driver, ContactUs.class); contact.go(driver);
	 * contact.sendForm("Tomas", "Test", "its working?");//complete all the
	 * fields but mail java.util.List<WebElement> lista =
	 * driver.findElements(By.id("cntctfrm_contact_form"));
	 * Assert.assertNull(lista.get(0), lista.get(0).getText());
	 * //System.out.println("resultado "+lista.get(0).getText()); testForm(); }
	 */

	@Test(description = "Case 6")
	public void calendar() {

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.go(driver);

		// Busco el calendario
		WebElement cal = driver.findElement(By.id("wp-calendar"));// .findElement(By.tagName("a"));

		// clikeo el mes
		cal.findElement(By.id("prev")).findElement(By.tagName("a")).click();

		// traigo todos los elementos del tag tbody (tabla del calendario)
		cal = driver.findElement(By.id("wp-calendar")).findElement(
				By.tagName("tbody"));

		// asigno a links todos los dias que tengan un link
		List<WebElement> links = cal.findElements(By.tagName("a"));

		// veo la cantidad de dias que tienen post en el mes
		links.size();
		Assert.assertEquals(links.size(), 1,
				"La cantidad de dias con Post en el mes es incorrecta");

		// clikeo el primer dia con post
		links.get(0).click();

		// compruebo la cantidad de post en el dia y devuelvo los titulos
		List<WebElement> posts = driver.findElement(By.id("content"))
				.findElements(By.tagName("article"));
		Assert.assertEquals(posts.size(), 2,
				"La cantidad de posts en el dia es incorrecta");
		
		// devulevo el titulo de cada post
		for (int i = 0; i < posts.size(); i++) {
			System.out.println("---------------------------------------------------------------------------------------------------------------------------- ");
			System.out.println("" + posts.get(i).getText());
			System.out.println();
		}
	}
}
