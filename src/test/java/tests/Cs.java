package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cs {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.instagram.com/");
        driver.manage().window().fullscreen();

        WebElement login = driver.findElement(By.name("username"));
        login.click();
        login.sendKeys("zhakypovmarlen");
        Thread.sleep(1500);
        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.sendKeys("Lensberk08!");
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//button)[2]")).click();
    }
}
