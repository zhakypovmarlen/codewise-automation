package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class PaymentGatewayPage {

    public PaymentGatewayPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(linkText = "Cart")
    public WebElement cartLink;

    @FindBy(linkText = "Generate Card Number")
    public WebElement generateCardNumberLink;

    @FindBy(linkText = "Check Credit Card Limit")
    public WebElement checkCreditCardLimitLink;

    @FindBy(xpath = "//ul//input")
    public WebElement buyNowButton;

    @FindBy(id = "card_nmuber")
    public WebElement cardNumberInput;

    @FindBy(id = "month")
    public WebElement monthDropdown;

    @FindBy(id = "year")
    public WebElement yearDropdown;

    @FindBy(id = "cvv_code")
    public WebElement cvvInput;

    @FindBy(name = "submit")
    public WebElement payButton;

    @FindBy(xpath = "(//h3)[2]")
    public WebElement orderIDNumber;
    public void selectMonth(String month){
        Select select = new Select(monthDropdown);
        select.selectByVisibleText(month);
    }

    public void selectYear(String year){
        Select select = new Select(yearDropdown);
        select.selectByVisibleText(year);
    }

}
