package blazedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DestinationOfTheWeek {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://blazedemo.com");
//        WebElement vacationLink = driver.findElement(By.linkText("destination of the week! The Beach!"));
//        vacationLink.click();

        List <WebElement> elements = driver.findElements(By.xpath("/html/body/div[2]/div/p"));
        System.out.println(elements.size());
        System.out.println(elements.get(0).getText());
        System.out.println(elements.get(1).getText());
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//input")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//input[1]")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.id(""));

        driver.findElement(By.xpath("//h1/../p/a")).click();
        System.out.println(driver.findElement(By.xpath("//div[2]")).getText());
        if(driver.findElement(By.xpath("//div[2]")).getText().contains("Hawaii")){
            System.out.println("It is Hawaii");
        } else {
            System.out.println("It is not Hawaii");
        }
    }
}
