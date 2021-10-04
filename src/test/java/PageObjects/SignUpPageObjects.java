package PageObjects;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPageObjects {

	private WebDriver driver;
	
	private By signup = By.id("h_sin_up");
	private By nameBox = By.id("lgn_name");
	private By mobileBox = By.id("lgn_mob");
	private By sendOtpBtn = By.id("lgn_smtn");
	private By otpSent = By.xpath("//div[text()=\"OTP is sent on number\"]");
	private By errorMsg = By.xpath("//div[@class='error dn wrapper']");
	private By logIn = By.id("h_login");
	private By confirmLogIN = By.xpath("//span[@class='welcome']");
	
	public SignUpPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void validateWebsite() {
		String expected = "Justdial - Local Search, Social, News, Videos, Shopping";
		WebDriverWait wait = new WebDriverWait(driver,30);
		boolean b = wait.until(ExpectedConditions.titleContains(expected));
		Assert.assertEquals("title match", true, b);
	}
	
	public void clickOnSignUp() {
		driver.findElement(signup).click();
	}
	
	public void setSignUpBox(String name,String mobile) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(nameBox));
		driver.findElement(nameBox).sendKeys(name);
		driver.findElement(mobileBox).sendKeys(mobile);	
	}
	
	public void clickOnOtpBtn() {
		driver.findElement(sendOtpBtn).click();
	}
	
	public void msgDisplayed(String msg) {
		String s = driver.findElement(otpSent).getText();
		String expected = "OTP is sent on number";
		Assert.assertEquals("Otp sent text match", expected, s);
	}
	
	public void clickOnLogIn() {
		driver.findElement(logIn).click();
	}
	
	public void setLoginBox(String username, String usermob) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(nameBox));
		driver.findElement(nameBox).sendKeys(username);
		driver.findElement(mobileBox).sendKeys(usermob);
	}
	
	public void errorMsg(String msg) {
		String s = driver.findElement(errorMsg).getText();
		String expected = "Please Enter valid Mobile number!";
		Assert.assertEquals("error msg for wrong mob no.", expected, s);
	}
	
	public void checkMobLength(String num) {
		String attribute = driver.findElement(mobileBox).getAttribute("maxlength");
		if (attribute.equals(num)){
			Assert.assertTrue(true);	
		}
		else {
			Assert.fail("not match max length");
		}
	}
	
	public void logInConfirm() {
		String s = driver.findElement(confirmLogIN).getText();
		String expected  = "sujeet";
		Assert.assertEquals("confirm", expected, s);
	}
}
