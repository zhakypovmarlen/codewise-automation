package artOfTesting;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PopupsAndAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");


        // Alert Box

        Actions actions = new Actions(driver);
        WebElement alertBtn = driver.findElement(By.xpath("//div[@id='AlertBox']/button"));
        actions.scrollToElement(alertBtn).perform();
        Thread.sleep(1000);

        alertBtn.click();
        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        Thread.sleep(1000);
        driver.findElement(By.id("male")).click();

        Thread.sleep(1000);



        // Confirm Box

        WebElement confirmBox = driver.findElement(By.xpath("//div[@id='ConfirmBox']/button"));
        actions.scrollToElement(confirmBox).perform();
        confirmBox.click();
        Thread.sleep(1000);

        System.out.println(alert.getText());
        alert.dismiss();
        Thread.sleep(1000);

        String actualMessage = driver.findElement(By.xpath("//div[@id='ConfirmBox']/p[2]")).getText();
        String expectedMessage = "You pressed Cancel!";
        if(actualMessage.equals(expectedMessage)){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }


        // Double click


        WebElement doubleClickBtn = driver.findElement(By.id("dblClkBtn"));
        actions.doubleClick(doubleClickBtn).perform();

        String actualDblClkMsg = alert.getText();
        Thread.sleep(1000);

        alert.accept();

        String expectedDblClkMsg = "Hi! Art Of Testing, Here!";

        if(actualDblClkMsg.equals(expectedDblClkMsg)){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }


    }
}
