package DownloadAndUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Download {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement fileDownloadLink = driver.findElement(By.linkText("File Download"));
        fileDownloadLink.click();

        WebElement image = driver.findElement(By.linkText("test.jpg"));
        image.click();
    }
}
