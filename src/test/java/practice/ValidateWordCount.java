package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ValidateWordCount {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");

        driver.findElement(By.xpath("//*[@id='searchInput']")).sendKeys("Muhammed Ali", Keys.ENTER);

        Actions actions = new Actions(driver);
        Thread.sleep(1500);
        actions.keyDown(Keys.COMMAND).sendKeys("a","c").keyUp(Keys.COMMAND).perform();

        driver.get("https://wordcounter.net/");
        driver.findElement(By.xpath("(//textarea)[1]")).sendKeys(Keys.COMMAND,"v");

        WebElement count = driver.findElement(By.xpath("//span[@class='counted']"));
        String s = count.getText();
//        int s1 = Integer.parseInt(s);
//        for(int i = 0; i < s.length(); i++){
//            if(s.charAt(i) == )
//        }
    }
}
