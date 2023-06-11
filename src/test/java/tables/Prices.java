package tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Prices {

    static WebDriver driver;

    public static void main(String[] args) {
         driver = new ChromeDriver();
         driver.get("https://blazedemo.com/reserve.php");
         for(WebElement s : flightsBetweenCertainRange(300,500)){
             flightInfo(Integer.parseInt(s.getText()));
             System.out.println();
         }

    }

    public static List<WebElement> flightsBetweenCertainRange(double from, double until){
        List<WebElement> row = driver.findElements(By.xpath("//thead/tr/th"));
        List<WebElement> flightNumbers = new ArrayList<>();
        for(int i = 1; i < row.size(); i++){
            String price = driver.findElement(By.xpath("//tr["+i+"]//td[6]")).getText().replace("$","");
            double v = Double.parseDouble(price);
            if(from < v && v < until ){
                flightNumbers.add(driver.findElement(By.xpath("//tr["+i+"]//td[2]")));
            }
        }

        return flightNumbers;

    }
    public static void flightInfo(int num){
        List <WebElement> flightNumbers = driver.findElements(By.xpath("//tr//td[2]"));

        for(int i = 0; i < flightNumbers.size(); i++){
            int flight = Integer.parseInt(flightNumbers.get(i).getText());
            if(flight == num){
                i++;
                System.out.println("Flight Info for: " + flight);
                System.out.println("Airline: " + driver.findElement(By.xpath("//tr["+i+"]//td["+3+"]")).getText());
                System.out.println("Departure: " + driver.findElement(By.xpath("//tr["+i+"]//td["+4+"]")).getText());
                System.out.println("Arrives: " + driver.findElement(By.xpath("//tr["+i+"]//td["+5+"]")).getText());
                System.out.println("Price: " + driver.findElement(By.xpath("//tr["+i+"]//td["+6+"]")).getText());
            }
        }
    }
}
