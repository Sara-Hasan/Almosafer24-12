package AlmosaferWeb;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends Parameters{

	@BeforeTest
	public void MySetup() {
		driver.get(Url);
		driver.manage().window().maximize();
		
		
		WebElement popUPScreen = driver.findElement(By.className("sc-iBmynh"));
		
		if(popUPScreen.isDisplayed()) {
			WebElement SARButton = driver.findElement(By.className("cta__saudi"));
			SARButton.click();
		}else {
			WebElement ConButton = driver.findElement(By.className("cta__continue"));
			ConButton.click();
		}
	}
	@Test (priority = 1 , enabled = false)
	public void CheckTheDefultLanaguageIsEnglish() {
		
		String ExceptedLanaguage = "EN";
		String ActualLanaguage = driver.findElement(By.tagName("html")).getAttribute("lang").toUpperCase();
		
//		System.out.println(ActualLanaguage);
		assertEquals(ActualLanaguage, ExceptedLanaguage);
	}
	
	
	@Test(priority = 2, enabled = false)
	public void CheckTheDefultCurrencyIsSAR() {
		
		String ExceptedCurrency = "SAR";
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();
		
//		System.out.println(ActualCurrency);
		assertEquals(ActualCurrency, ExceptedCurrency);
	}
	@Test(priority = 3, enabled = false)
	public void CheckContactNumber() {
		
		String ExceptedContactNumber = "+966554400000";
		String ActualContactNumber = driver.findElement(By.tagName("strong")).getText();
		
		assertEquals(ActualContactNumber, ExceptedContactNumber);
	}
	
	@Test(priority = 4, enabled = false)
	public void CheckQitafLogo() {
		WebElement TheFooter = driver.findElement(By.tagName("footer"));
		boolean QitafLogo = TheFooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed();
	
		assertEquals(QitafLogo, true);
	}
	@Test(priority = 5, enabled = false)
	public void CheckHotelTabsIsNotSelected() {
		
		String HotelTabs = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected");
		
		assertEquals(HotelTabs, "false");
		
	}
	@Test(priority = 6 , enabled = false)
	public void CheckDepatureDateAndReturnDate () {
		
		LocalDate today = LocalDate.now();
		
		int ExpectedDepatureDate = today.plusDays(1).getDayOfMonth();
		int ExpectedReturnDate = today.plusDays(2).getDayOfMonth();
		
		
//		System.out.println(ExpectedDepatureDate);
//		System.out.println(ExpectedReturnDate);
		
		int ActualDepatureDate =Integer.parseInt(driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']")).getText());
		
		int ActualReturnDate =Integer.parseInt(driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']")).getText());
		
//		System.out.println(ActualDepatureDate);
//		System.out.println(ActualReturnDate);
		
		assertEquals(ActualDepatureDate, ExpectedDepatureDate);
		assertEquals(ActualReturnDate, ExpectedReturnDate);
	}
	
	@Test(priority = 7 )
	public void RandomMethodToChangeTheLanaguage() {
		Random rand = new Random();
		
		int randomIndexForTheWebsite = rand.nextInt(Website.length);
		driver.get(Website[randomIndexForTheWebsite]);
		
		if(driver.getCurrentUrl().contains("ar")) {
			String ExceptedLang = "ar";
			String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
			assertEquals(ActualLang, ExceptedLang);
			
		}else {
			String ExceptedLang = "en";
			String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
			assertEquals(ActualLang, ExceptedLang);
		}
	}
	
	@Test(priority = 8)
	public void SwitchToHotelTab() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();
		
		
		 
		 
		 if(driver.getCurrentUrl().contains("ar")) {
			 WebElement SearchCityInput = driver.findElement(By.cssSelector("input[placeholder='البحث عن فنادق أو وجهات']"));
			 SearchCityInput.sendKeys(CitiesInArabic[randomArabicCity]);
		 }else {
			 WebElement SearchCityInput = driver.findElement(By.cssSelector("input[placeholder='Search for hotels or places']"));
			 SearchCityInput.sendKeys(CitiesInEnglish[randomEnglishCity]);
		 }
	}
	
	@AfterTest
	public void myPostTest() {
		
	}
	
}
