package iFrame;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;


public class Local {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///Users/marlen/Desktop/my_iFrame_website.html");


        List<WebElement> texts = driver.findElements(By.xpath("//h1"));

        System.out.println(texts.size());


        WebElement secondFrame = driver.findElement(By.xpath("//iframe[2]"));
        driver.switchTo().frame(secondFrame);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce" + Keys.ENTER);

        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        driver.findElement(By.id("confirmbtn")).click();

        Thread.sleep(1500);

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.xpath("//*[.='iFrame Example']"))).perform();
//        actions.scrollToElement(driver.findElement(By.xpath("//*[.='iFrame Example']"))).perform();
//        actions.scrollByAmount(0,800).perform();
        driver.switchTo().frame("courses-iframe");

        actions.scrollToElement(driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li"))).perform();
        List<WebElement> menuButtons = driver.findElements(By.xpath("//div[@class='collapse navbar-collapse']/ul/li"));
        System.out.println(menuButtons.size());

        for(WebElement s : menuButtons){
            actions.moveToElement(s).perform();
            Thread.sleep(1000);
        }







    }
}
