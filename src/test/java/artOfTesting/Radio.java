package artOfTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");

        WebElement male = driver.findElement(By.id("male"));

        WebElement female = driver.findElement(By.id("female"));

        WebElement automation = driver.findElement(By.className("Automation"));


        WebElement performance = driver.findElement(By.className("Performance"));


        System.out.println("Before: " + male.isSelected());
        male.click();
        System.out.println("After: " + male.isSelected());

/*
        if(male.isSelected() && !female.isSelected()){
            System.out.println("Male Radio Button is selected");
        } else if(!male.isSelected() && female.isSelected()){
            System.out.println("Female Radio Button is selected");
        } else {
            System.out.println("Nothing is selected");
        }
*/
        System.out.println("Before: " + (automation.isSelected()));
        automation.click();
        System.out.println(automation.isSelected() + "\n");

        System.out.println("Male Radio Button Before: " + male.isSelected());
        female.click();
        System.out.println("Clicking female button");
        System.out.println("Male Radio Button After: " + male.isSelected());

        System.out.println(male.getAttribute("type"));


    }
}
