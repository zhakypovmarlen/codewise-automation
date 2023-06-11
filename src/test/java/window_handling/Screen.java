package window_handling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.util.Set;

public class Screen {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");

        driver.switchTo().newWindow(WindowType.TAB).get("https://youtube.com");
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://etsy.com");
        driver.switchTo().newWindow(WindowType.TAB).get("https://facebook.com");
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://instagram.com");

        Set<String> IDs = driver.getWindowHandles();
        Actions actions = new Actions(driver);


        for(String id : IDs){
            driver.switchTo().window(id);
            if(driver.getTitle().contains("Etsy")){
                driver.close();
                break;
            }
        }


        System.out.println(driver.getCurrentUrl());

    }
}
