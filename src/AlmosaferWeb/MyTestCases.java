package AlmosaferWeb;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
	
	@Test(priority = 8 ,enabled = false)
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
		 
		 WebElement theList = driver.findElement(By.className("UzzIN")); 
			
			System.out.println(theList.findElements(By.tagName("li")).size());
			
			theList.findElements(By.tagName("li")).get(1).click();
//		 WebElement theList = driver.findElement(By.className("phbroq-4"));
//		 
//		 System.out.println(theList.findElements(By.tagName("li")).size());
//		 theList.findElements(By.tagName("li")).get(1).click();
		 
	}
	
	
	@Test(priority = 8)
	public void switchToHotelTab() throws InterruptedException {

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();

		if (driver.getCurrentUrl().contains("ar")) {
			WebElement searchCityInput = driver
					.findElement(By.cssSelector("input[placeholder='البحث عن فنادق أو وجهات']"));

			searchCityInput.sendKeys(CitiesInArabic[randomArabicCity]);
		} else {
			WebElement SearchCityInput = driver
					.findElement(By.cssSelector("input[placeholder='Search for hotels or places']"));

			SearchCityInput.sendKeys(CitiesInEnglish[randomEnglishCity]);
		}
		Thread.sleep(7000);
		WebElement theList = driver.findElement(By.className("UzzIN")); 
//		Thread.sleep(3000);
		
		System.out.println(theList.findElements(By.tagName("li")).size());
		
		theList.findElements(By.tagName("li")).get(1).click();
		
	}
	
	@Test(priority = 9)
	public void RandomlySelectTheVisitorNumber() {
		WebElement Visitor = driver.findElement(By.className("tln3e3-1"));
		Select selector = new Select(Visitor);
		
//		selector.selectByIndex(1);
//		selector.selectByValue("B");
		
		if(driver.getCurrentUrl().contains("ar")) {
			selector.selectByVisibleText("1 غرفة، 1 بالغ، 0 أطفال");
		}else {
			selector.selectByVisibleText("1 Room, 1 Adult, 0 Children");
		}
		driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div[2]/div/div[4]/button")).click();
	}
	
	@Test(priority = 10)
	public void MakeSureIsPAgeFullyLoaded() throws InterruptedException {
		Thread.sleep(10000);
		String SearchResult = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section/span")).getText();
		if(driver.getCurrentUrl().contains("ar")) {
			boolean ActualResult = SearchResult.contains("وجدنا");
			assertEquals(ActualResult, true);
		}else {
			boolean ActualResult = SearchResult.contains("found");
			assertEquals(ActualResult, true);
		}
		
	}
	@Test(priority = 11)
	public void sortItemBasedOnThePrice() throws InterruptedException {
		Thread.sleep(10000);
		WebElement LowestPriceButton = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[2]/section[1]/div/button[2]"));

		LowestPriceButton.click();
		WebElement HotelsContainer = driver.findElement(By.cssSelector(".sc-htpNat.KtFsv.col-9"));

		List<WebElement> thePricesList = HotelsContainer.findElements(By.className("Price__Value"));
		
		System.out.println(thePricesList.size() + "this is the total prices found ");
		
		String LowestPriceOnTheList = thePricesList.get(0).getText();
		int LowestPriceOnTheListAsNumber = Integer.parseInt(LowestPriceOnTheList);

		String HighestPriceOnTheList = thePricesList.get(thePricesList.size()-1).getText();
		int HighestPriceOnTheListAsNumber = Integer.parseInt(HighestPriceOnTheList);
		
		System.out.println("this the minimum value " + LowestPriceOnTheList);
		System.out.println("this the maximum value " + HighestPriceOnTheList);
		
		assertEquals( HighestPriceOnTheListAsNumber > LowestPriceOnTheListAsNumber, true);
	}
	
	@AfterTest
	public void myPostTest() {
		
	}
	
}
