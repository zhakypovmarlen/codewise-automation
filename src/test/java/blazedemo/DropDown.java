package blazedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropDown {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com");

        WebElement departureDropDown = driver.findElement(By.name("fromPort"));
        WebElement destinationDropDown = driver.findElement(By.name("toPort"));

//        List<WebElement> departureCityBtn = driver.findElements(By.xpath("//select[1]/option"));
//        List<WebElement> destinationCityBtn = driver.findElements(By.xpath("//select[2]/option"));

        Select departureCities = new Select(departureDropDown);
        Select destinationCities = new Select(destinationDropDown);

        String departureDefault = departureCities.getFirstSelectedOption().getText();
        System.out.println(departureDefault);

        String destinationDefault = destinationCities.getFirstSelectedOption().getText();
        System.out.println(destinationDefault);

        List<WebElement> departureOptions = departureCities.getOptions();
        List<String> requirementCities = new ArrayList<>();
        requirementCities.add("Mexico City");
        requirementCities.add("São Paolo");
        requirementCities.add("Paris");
        requirementCities.add("Philadelphia");
        requirementCities.add("Boston");
        requirementCities.add("Portland");
        requirementCities.add("San Diego");



        int count = 0;
        for(WebElement option : departureOptions){
            for(int i = 0; i < requirementCities.size(); i++){
                if(option.getText().equals(requirementCities.get(i))){
                    count++;
                }
            }
        }
        if(requirementCities.size() == count){
            System.out.println("All cities are there");
        } else {
            System.out.println("Not all cities are there");
        }

//        for(WebElement option : departureOptions){
//            if(requirementCities.contains(option)){
//                System.out.println("City passed");
//            } else {
//                System.out.println("City failed");
//            }
//        }

        departureCities.selectByVisibleText("Boston");
        Thread.sleep(500);
        departureCities.selectByIndex(4);
        Thread.sleep(500);
        departureCities.selectByValue("Mexico City");
        destinationCities.selectByVisibleText("Dublin");


    }
}
