package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Table {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");

        Actions actions = new Actions(driver);
//        WebElement doubleClickAlert = driver.findElement(By.id("dblClkBtn"));
//        actions.doubleClick(doubleClickAlert).perform();

        WebElement toHoverOver = driver.findElement(By.xpath("//li[@id='menu-item-98']/a"));
        actions.moveToElement(toHoverOver).perform();


    }
}
