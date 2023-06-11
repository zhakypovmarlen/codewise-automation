package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Hover {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");

        Actions actions = new Actions(driver);
//        WebElement menu = driver.findElement(By.xpath("//a[contains(text(),'Automation')]"));
//        actions.moveToElement(menu).perform();
//        driver.findElement(By.xpath("//li[@id='menu-item-1008']/a")).click();
//        actions.scrollToElement(driver.findElement(By.xpath("//div[*='Useful Resources']/h2"))).perform();
        WebElement home = driver.findElement(By.xpath("//*[text()='Home']"));
        actions.moveToElement(home).perform();
        Thread.sleep(1000);

        WebElement manual = driver.findElement(By.xpath("//*[text()='Manual']"));
        actions.moveToElement(manual).perform();
        Thread.sleep(1000);

        WebElement automation = driver.findElement(By.xpath("//*[text()='Automation']"));
        actions.moveToElement(automation).perform();
        Thread.sleep(1000);

        WebElement performance = driver.findElement(By.xpath("//*[text()='Performance']"));
        actions.moveToElement(performance).perform();
        Thread.sleep(1000);

        WebElement java = driver.findElement(By.xpath("//*[text()='Java']"));
        actions.moveToElement(java).perform();
        Thread.sleep(1000);

        WebElement interview = driver.findElement(By.xpath("//*[text()='Interview']"));
        actions.moveToElement(interview).perform();
        Thread.sleep(1000);

        WebElement blog = driver.findElement(By.xpath("//*[text()='Blog']"));
        actions.moveToElement(blog).perform();
        Thread.sleep(1000);



    }
}
