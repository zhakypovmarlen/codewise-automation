package DownloadAndUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Upload {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement uploadFile = driver.findElement(By.linkText("File Upload"));
        uploadFile.click();

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/marlen/Desktop/barhatnye tyagi.jpeg");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        String actualText = driver.findElement(By.xpath("//h3")).getText();

        if(actualText.equals("File Uploaded!")){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }




    }
}
