package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class practice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.letskodeit.com/practice");

        List<WebElement> menuBtn = driver.findElements(By.xpath("//ul[@class='nav navbar-nav pull-center dynamic_menu_texts']/li"));
        menuBtn.get(1).click();
        Thread.sleep(1000);
        driver.navigate().to("https://amazon.com");
        driver.navigate().back();
        menuBtn.get(1).click();
        asd();
    }

     static public void asd(){
         System.out.println("qwe");
    }
}
