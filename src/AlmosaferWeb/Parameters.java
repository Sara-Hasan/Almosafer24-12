package AlmosaferWeb;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {

	WebDriver driver = new ChromeDriver();
	
	String Url = "https://www.almosafer.com/en";
	
	Random randForCity =new Random();
	
	String [] Website = {"https://www.almosafer.com/en","https://www.almosafer.com/ar"};
	
	String [] CitiesInEnglish = {"dubai", "jedda","riyadh"};
	int randomEnglishCity = randForCity.nextInt(CitiesInEnglish.length);
	
	String [] CitiesInArabic = {"جدة", "دبي"};
	int randomArabicCity = randForCity.nextInt(CitiesInArabic.length);
	
	}
