package actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");


        Actions actions = new Actions(driver);
//        actions.scrollToElement(driver.findElement(By.linkText("Selenium Tutorial"))).perform();
//        actions.scrollByAmount(0,400).perform();
//        WebElement dragAndDrop1 = driver.findElement(By.xpath("//div[@ondrop='drop(event)']"));
//        WebElement picture = driver.findElement(By.xpath("//img[@id='myImage']"));
//        actions.dragAndDrop(picture, dragAndDrop1).build().perform();

        WebElement link = driver.findElement(By.linkText("Selenium Sample Script"));
        WebElement link2 = driver.findElement(By.linkText("This is a link"));
        WebElement textBox = link.findElement(By.id("fname"));
        actions.clickAndHold(link).moveToElement(textBox).perform();
        actions.moveToElement(textBox).perform();




    }
}
