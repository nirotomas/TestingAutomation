package tomas_niro.training.globant.com.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import tomas_niro.training.globant.com.pages.Booking;
import tomas_niro.training.globant.com.pages.Flights;
import tomas_niro.training.globant.com.pages.HomePage;
import tomas_niro.training.globant.com.pages.Logg;
import tomas_niro.training.globant.com.pages.Results;
import tomas_niro.training.globant.com.pages.TravelerInfo;
import tomas_niro.training.globant.com.pages.TripDetails;

public class Tests {
	WebDriver driver;
	HomePage homePage = PageFactory.initElements(driver, HomePage.class);

	@BeforeMethod
	@Parameters("browser")
	public void before(String browser) throws MalformedURLException {
		System.out.println(browser);
		if (browser.equals("FF")) {
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(
					new URL("http://localhost:4441/wd/hub"), capability);
		}
		if (browser.equals("CH")) {
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(
					new URL("http://localhost:4441/wd/hub"), capability);
		}
		if (browser.equals("IE")) {
			DesiredCapabilities capability = DesiredCapabilities
					.internetExplorer();
			capability
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			driver = new RemoteWebDriver(
					new URL("http://localhost:4441/wd/hub"), capability);
		}
		driver.get("http://www.cheaptickets.com/");
		Reporter.log("Se Entro a la Pagina Correctamente\n");
	}

	@AfterMethod
	public void after() {
		driver.close();
		driver.quit();
	}

	  @Test(description = "case1")
	  public void testLogin() throws InterruptedException { 
		  loggIn(); 
	  }
	  	
	  @Test(description = "case2")
	  public void testLoginUserFail() throws InterruptedException
	  {
		  String usr = "primer_test1";
		  Logg logg = homePage.goLogin(driver);
		  logg.go(driver);
		  logg.logIn(driver, usr + "@t.com", "Kkrr11al!");
		  pausa(5);
		  Assert.assertEquals(driver.findElement(By.className("signInForm")).getText(),"The e-mail and password you have entered do not match. Please try again.\nEmail\nPassword\nRemember my email when I return.\nForgot your password?");
	  }
	  
	  @Test(description = "case3")
	  public void testLoginPsswFail() throws InterruptedException { 
		  String usr = "primer_test1";
		  Logg logg = homePage.goLogin(driver);
		  logg.go(driver);
		  logg.logIn(driver, usr + "@t.com", "Kkrr11al0!");
		  pausa(5);
		  Assert.assertEquals(driver.findElement(By.className("signInForm")).getText(),"The e-mail and password you have entered do not match. Please try again.\nEmail\nPassword\nRemember my email when I return.\nForgot your password?");
	  }
	 
	
	  @Test(description="case4")
	  public void case4() throws InterruptedException{ 
		String usr = "primer_test"; 
	  	Logg logg = homePage.goLogin(driver); 
	  	logg.go(driver);
	  	logg.logIn(driver,usr + "@t.com", "Kkrr11al!"); 
	  	pausa(5);
	  	logg.signOut(driver);
	  	pausa(5);
	  	Assert.assertEquals(logg.signedOut(driver), "You are now signed out");
	  }

	@Test(description = "case5")
	public void testFlight() throws InterruptedException {
		selectFlight(false);
	}

	@Test(description="case6")
	public void case6() throws InterruptedException{
		Flights flight = PageFactory.initElements(driver, Flights.class);
		flight.go(driver);
		pausa(5);
		flight.inputFromTo(driver,
				"Las Vegas, Nevada - Las Vegas McCarran Intl Airport (LAS)",
				"Los Angeles, California - Los Angeles Airport, El Segundo (LAX)");
		flight.pickDate(driver,"03/15/15","03/10/15");
		flight.submit(driver);
		pausa(5);
		Assert.assertEquals(driver.findElement(By.id("main")).findElement(By.id("search")).findElement(By.className("airFormMod ")).findElement(By.cssSelector("div.airSearchForm.searchForm ")).findElement(By.className("searchFormForm ")).findElement(By.tagName("fieldset")).findElement(By.tagName("p")).getText(), "That date/time has already passed. Please select a new date/time.");
	}
	
	@Test(description="case7 - Definir y automatizar un test positivo dentro del "
			+ "flujo de búsqueda y reservación de vuelos.")
	public void case7() throws InterruptedException{
		selectFlight(false);
	}

	@Test(description="case8")
	public void case8() throws InterruptedException{
		//logg in
		loggIn();
		selectFlight(true);
	  
	}
	

	@Test(description="case9")
	public void case9() throws InterruptedException{
		
		//initialize flight page
		Flights flight = PageFactory.initElements(driver, Flights.class);
		flight.go(driver);
		pausa(5);
		//select hotel+flight option
		driver.findElement(By.id("search.type.aph")).click();
		pausa(10);
		
		//filling search fields
		flight.flight_hotel(driver,"03/25/15","03/26/15","Las Vegas, Nevada - Las Vegas McCarran Intl Airport (LAS)", "Los Angeles Airport, El Segundo, Los Angeles, CA, United States");
		pausa(20);
		
		//verify and select flight+hotel results
		flight.hotel_flight_rsts(driver);
		
		//initialize tripDetail page and verify its info
		TripDetails tripDetail = PageFactory.initElements(driver, TripDetails.class);
		tripDetail.verifyInfo(driver);

	}

	private void pausa(int s) throws InterruptedException {
		Thread.sleep(s * 1000);
	}

	private void closePopUp(){
		String mainWindow = getMainWindowHandle(driver);
		Assert.assertTrue(closeAllOtherWindows(mainWindow, driver));
	}
	public String getMainWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}
	public static boolean closeAllOtherWindows(String openWindowHandle, WebDriver driver) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				driver.close();
			}
		}
		
		driver.switchTo().window(openWindowHandle);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void loggIn() throws InterruptedException{
		  String usr = "primer_test";
		  Logg logg = homePage.goLogin(driver);
		  logg.go(driver);
		  pausa(5);
		  logg.logIn(driver, usr + "@t.com", "Kkrr11al!");
		  pausa(5);
		  Assert.assertNotEquals(logg.welcome(driver), "Welcome to CheapTickets");
	}

	private void selectFlight(boolean logged) throws InterruptedException {
		
		//initialize Flight page
		Flights flight = PageFactory.initElements(driver, Flights.class);
		flight.go(driver);
		pausa(5);
		//complete search fields
		flight.inputFromTo(driver,
				"Las Vegas, Nevada - Las Vegas McCarran Intl Airport (LAS)",
				"Los Angeles, California - Los Angeles Airport, El Segundo (LAX)");

		flight.pickDate(driver,"03/25/15","03/26/15");
		flight.submit(driver);
		try {

			pausa(20);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			closePopUp();
			
			//initialize results page
			Results rsts = PageFactory.initElements(driver, Results.class);
			//verify results
			rsts.verifyResults(driver);
			//sort by price
			rsts.sortByPrice(driver);

			pausa(10);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//select first match
			rsts.selectFirst(driver);
			
			pausa(20);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//initialize booking page
			Booking booking = PageFactory.initElements(driver, Booking.class);
			booking.verifyTripDetail(driver);
			booking.submit(driver);
			
			pausa(5);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//go traveler info page
			booking.goTravelerInfo(driver);
			
			pausa(5);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//initialize traveler info page
			TravelerInfo traveler = PageFactory.initElements(driver,
					TravelerInfo.class);
			
			//complete traveler info
			traveler.fillInfo(driver, "tomas", "miapellido", "3512158777", "t@t.com", logged);
			pausa(5);
			
			traveler.continuar(driver,logged);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
}//class end


