package SDA.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import SDA.utilities.Driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EBayPage {
    //Day20:HW04
    // Navigate to https://www.ebay.com/
    // Perform a search after typing {search_keyword} in the search box
    // Add the first product in the search results to the cart
    // Go to the cart
    // Increase the quantity of the purchased product to {quantity}
    // Verify the total amount in the cart should be calculated as unit productPrice * quantity
    public EBayPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "gh-ac")
    WebElement searchBox;

    @FindBy (xpath = "//*[contains(@class,'srp-results')]/li[@data-viewport]/div/div")
    WebElement firstItem;

    @FindBy (xpath = "//*[@data-testid='ux-call-to-action']/span/span[.='Add to cart']")
    WebElement addToCartButton;

    @FindBy (xpath = "//*[@data-test-id='qty-dropdown']")
    WebElement quantityDropDown;


    @FindBy(xpath = "//*[@class='gh-cart-icon']")
    WebElement cartButton;

    @FindBy(xpath = "//*[@class='price-details']/div/span/span/span")
    WebElement itemPrice;
    @FindBy(xpath = "//*[@class= 'fake-link' and contains(@aria-label,'Remove')]")
    WebElement removeButton;

    public void searchFor(String searchKey){
        searchBox.sendKeys(searchKey, Keys.ENTER);
    }


    public void addFirstItem(){
        String mainPage = Driver.getDriver().getWindowHandle();

        firstItem.click();
        Set<String> Handles =Driver.getDriver().getWindowHandles();
        Iterator<String> itr = Handles.iterator();
        List<String> li =new ArrayList<>();

        while (itr.hasNext()){
            li.add(itr.next());
        }

        String newHandle="";
        for(String handle: li){
            if(!handle.equals(mainPage)){
                newHandle=handle;
            }
        }

        Driver.getDriver().switchTo().window(newHandle);
        addToCartButton.click();

        cartButton.click();


    }
    public void increaseQuantity(int quantity) throws InterruptedException {
        double price =Double.parseDouble(itemPrice.getText().substring(4));

        Select select=new Select(quantityDropDown);
        switch (quantity){
            case 1:
                select.selectByValue("1");
                break;
            case 2:
                select.selectByValue("2");
                break;
            case 3:
                select.selectByValue("3");
                break;
            case 4:
                select.selectByValue("4");
                break;
            case 5:
                select.selectByValue("5");
                break;
            case 6:
                select.selectByValue("6");
                break;
            default:
                System.out.println("you can select only from 1-6");
        }
        Thread.sleep(2000);

        double newPrice =Double.parseDouble(itemPrice.getText().substring(4));

        Assert.assertEquals(newPrice,price*quantity);
        Thread.sleep(1000);
        removeButton.click();
        Thread.sleep(3000);

    }

}