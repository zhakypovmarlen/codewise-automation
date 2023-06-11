package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

    public static void main(String[] args) {
        System.out.println("Hello World");

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        driver.navigate().to("https://amazon.com");
        System.out.println(driver.getTitle());
        driver.navigate().back();
        driver.navigate().refresh();




        driver.get("https://google.com");
        if(driver.getTitle().equalsIgnoreCase("Google")){
            System.out.println("Test passed");
        } else {
            System.out.println("The Title of google.com is " + driver.getTitle());
            System.out.println("Test failed!");
        }
        driver.get("https://amazon.com");
        if(driver.getTitle().equalsIgnoreCase("Hey, Amazon!")){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        driver.close();



    }
}
