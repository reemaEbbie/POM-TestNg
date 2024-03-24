package SDA.pages.XYZBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SDA.utilities.Driver;

public class CreateNewCustomerPage {

    public CreateNewCustomerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@ng-model='fName']")
    WebElement firstNameField;
    @FindBy (xpath = "//*[@ng-model='lName']")
    WebElement lastNameField;
    @FindBy (xpath = "//*[@ng-model='postCd']")
    WebElement postCodeField;
    @FindBy (xpath = "//*[@type='submit']")
    WebElement addNewCustomerButton;
    public void createNewCustomer(String firstName, String lastName, String postCode){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postCodeField.sendKeys(postCode);
        addNewCustomerButton.click();
    }
}