package window_handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Charger {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com");
        String mainPageID = driver.getWindowHandle();


        driver.findElement(By.xpath("//a[.='PRACTICE']")).click();

        Set<String> IDs = driver.getWindowHandles();
        for(String s : IDs){
            if(!s.equals(mainPageID)){
                driver.switchTo().window(s);
                break;
            }
        }
        String secondPageId = driver.getWindowHandle();

        driver.findElement(By.id("opentab")).click();

        IDs = driver.getWindowHandles();

        for(String s : IDs){
            if(!s.equals(mainPageID) && !s.equals(secondPageId)){
                driver.switchTo().window(s);
                break;
            }
        }

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.close();





    }
}
