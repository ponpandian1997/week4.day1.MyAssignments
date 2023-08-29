package week4.day1;


import java.time.Duration;
import java.util.ArrayList; 
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ajio2 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("searchVal")).sendKeys("bags" ,Keys.ENTER);
		Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		
		System.out.println("Count of the item is: " +driver.findElement(By.xpath("//div[@class='length']")).getText());
		//get the list of brand
		List<WebElement> brandname = driver.findElements(By.xpath("//div[@class='brand']"));
		System.out.println(brandname.size());
		for (int i = 0; i < brandname.size(); i++) {
			System.out.println(brandname.get(i).getText());
			}
		//get the name of tha bags
		List<WebElement> bagname = driver.findElements(By.xpath("//div[@class='nameCls']"));
		System.out.println(bagname.size());
		for (int i = 0; i < bagname.size(); i++) {
			System.out.println(bagname.get(i).getText());
			}
		//get the price and sort it
		List<WebElement> pricelist = driver.findElements(By.xpath("//span[@class='price  ']"));
		List<Integer> price = new ArrayList<Integer>();
		for (int i = 0; i < pricelist.size(); i++)
		   {
			String text = pricelist.get(i).getText();
			price.add(Integer.parseInt(text.replaceAll("[^0-9]", "")));
			}
		//sorting the rice
		Collections.sort(price);
		System.out.println("sorted price lists");
		for (int i = 0; i < price.size(); i++)
		System.out.println(price.get(i) + " ");
			
	    }
		
           
     }
		
	    


	


