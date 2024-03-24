package SDA.pages.XYZBank;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import SDA.utilities.Driver;

import java.util.List;

public class BankingProjectPage {
    public BankingProjectPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //Open 5 new  Accounts, deposit 100 USD and withdraw 100 USD from any account and delete all accounts you created.
    @FindBy (xpath = "//*[@ng-click='manager()']")
    WebElement bankManagerLoginButton;

    @FindBy (xpath = "//*[@ng-class='btnClass1']")
    WebElement addCustomerButton;
    @FindBy (xpath = "//*[@ng-class='btnClass2']")
    WebElement openAccountButton;
    @FindBy (xpath = "//*[@ng-class='btnClass3']")
    WebElement customersButton;


    @FindBy (id = "userSelect")
    WebElement customerDropDown;
    @FindBy (id = "currency")
    WebElement currencyDropDown;
    @FindBy (xpath = "//*[@type='submit']")
    WebElement processButton;

    @FindBy (tagName = "tbody")
    WebElement customerTable;

    @FindBy (xpath = "//*[@ng-click='home()']")
    WebElement homeButton;
    @FindBy (xpath = "//*[@ng-click='customer()']")
    WebElement customerLoginButton;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement LoginButton;

    @FindBy (xpath = "//*[@ng-class='btnClass2']")
    WebElement deposit;
    @FindBy (xpath = "//*[@ng-model='amount']")
    WebElement depositField;
    @FindBy (xpath = "//*[@type='submit']")
    WebElement depositButton;

    @FindBy (xpath = "//*[@ng-class='btnClass3']")
    WebElement withdraw;
    @FindBy (xpath = "//*[@ng-model='amount']")
    WebElement withdrawField;
    @FindBy (xpath = "//*[@type='submit']")
    WebElement withdrawButton;

    @FindBy (xpath = "//*[@ng-show='message']")
    WebElement verifyDepositMessage;
    @FindBy (xpath = "//*[@ng-show='message']")
    WebElement verifyWithdrawMessage;
    @FindBy (xpath = "//*[@ng-show='logout']")
    WebElement logout;

    @FindAll (@FindBy (xpath = "//*[@ng-click='deleteCust(cust)']"))
    List<WebElement> deleteButtons;

    public void clickBankManagerLoginButton(){
        bankManagerLoginButton.click();
    }
    public void clickAddCustomerButton(){
        addCustomerButton.click();
    }
    public void clickOpenAccountButton(){
        openAccountButton.click();
    }
    public void clickCustomersButton(){
        customersButton.click();
    }


    public void openAccount(String customer){
        Select selectCustomer=new Select(customerDropDown);
        selectCustomer.selectByVisibleText(customer);
        Select selectCurrency=new Select(currencyDropDown);
        selectCurrency.selectByValue("Dollar");
        processButton.click();

    }

    public void verifyTheNumberOfNewCustomer(int numberOfNewCustomer){
        List<WebElement> rows=customerTable.findElements(By.xpath(".//tr"));
        int countRows=0;
        //count the rows
        for (WebElement row: rows){
            countRows++;
        }
        // remove the default rows that will be existed Automatically
        countRows= countRows-5;
        Assert.assertEquals(countRows,numberOfNewCustomer);

    }

    public void Login(String customerName){
        homeButton.click();
        customerLoginButton.click();
        Select selectCustomer=new Select(customerDropDown);
        selectCustomer.selectByVisibleText(customerName);
        LoginButton.click();
    }

    public void deposit(int depositAmount){
        deposit.click();
        depositField.sendKeys(""+depositAmount);
        depositButton.click();
        Assert.assertTrue(verifyDepositMessage.isDisplayed());
    }

    public void withdraw(int withdrawAmount){
        withdraw.click();
        withdrawField.sendKeys(""+withdrawAmount);
        withdrawButton.click();
        Assert.assertTrue(verifyWithdrawMessage.isDisplayed());
    }
    public void clickLogOutButton(){
        logout.click();
    }
    public void clickHomeButton(){
        homeButton.click();
    }
    public void deleteAllCustomer(){
        clickLogOutButton();
        clickHomeButton();
        clickBankManagerLoginButton();
        clickCustomersButton();
        for (WebElement delete : deleteButtons){
            delete.click();
        }
        List<WebElement> rows=customerTable.findElements(By.xpath(".//tr"));
        int countRows=0;
        //count the rows
        for (WebElement row: rows){
            countRows++;
        }
        Assert.assertEquals(countRows,0);
    }


}