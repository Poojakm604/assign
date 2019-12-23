package assign1;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class A {
	static String price1;

	static String price2;
	
	public static void main(String[] args) throws Exception{
		//System.setProperty("webdriver.chrome.driver", "‪‪C:\\Users\\Abhishek\\Desktop\\chromedriver.exe");
   
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	WebElement search1 = driver.findElement(By.id("twotabsearchtextbox"));
	search1.sendKeys("iPhone XR()64GB - Yellow");
	driver.findElement(By.className("nav-input")).click();
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	price1 = driver.findElement(By.className("a-price-whole")).getText();
	
		
	//Integer num1= Integer.valueOf(price1);
	//driver.close();
	driver.get("https://www.flipkart.com");
	Actions actions = new Actions(driver);
	Action sendEsc = actions.sendKeys(Keys.ESCAPE).build();
	sendEsc.perform();

	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	
	WebElement search2 = driver.findElement(By.className("LM6RPg"));
	
	//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

	search2.sendKeys("iphone xr64gb - yellow");
	driver.findElement(By.className("_2BhAHa")).click();

	
	//driver.findElement(By.className("_3wU53n")).click();
	WebDriverWait wait =new WebDriverWait(driver,6);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.className("_3wU53n")));

	
	List<WebElement> element = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
	for(WebElement web: element) {
		
		String amount =web.getText();
		int length =amount.length();
		price2 =amount.substring(1, length);
		
		
		
		
	}
	try {
	int num1=Integer.parseInt(price1);
	int num2=Integer.parseInt(price2);
	
	if((num1)<(num2)) {
		System.out.println("flipkart price is higher");
	}else {
		System.out.println("amazon price is higher");
		
	}}catch(NumberFormatException e) {
		e.printStackTrace();
		
	}
	System.out.println("amazon price:"+ price1);

	System.out.println("flipkart price:"+ price2);

	}
	
}