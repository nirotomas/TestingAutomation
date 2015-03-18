package tomas_niro.training.globant.com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register {

	@FindBy(xpath = "html/body/div[8]/div[2]/div[2]/form/div/div[2]/div[1]/div/div[1]/div[2]/label[1]/input")
	private WebElement email;

	@FindBy(xpath = "html/body/div[8]/div[2]/div[2]/form/div/div[2]/div[1]/div/div[1]/div[2]/div[1]/label/input")
	private WebElement pssw;

	@FindBy(xpath = "html/body/div[8]/div[2]/div[2]/form/div/div[2]/div[1]/div/div[1]/div[2]/div[2]/label/input")
	private WebElement rtp_pssw;

	@FindBy(name = "_eventId_submit")
	private WebElement submit;

	public void goRegister(WebDriver driver) {
		driver.get("https://www.cheaptickets.com/account/registration?destinationUrl=%2F");
	}

	public void fillRegister(String email, String pssw, String rtp_pssw) {
		this.email.sendKeys(email);
		this.pssw.sendKeys(pssw);
		this.rtp_pssw.sendKeys(rtp_pssw);
	}

}
