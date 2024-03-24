package SDA.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import SDA.pages.XYZBank.BankingProjectPage;
import SDA.pages.XYZBank.CreateNewCustomerPage;
import SDA.utilities.ConfigReader;
import SDA.utilities.Driver;

public class C09_BankingProjectTest {


    BankingProjectPage bankingProjectPage = new BankingProjectPage();
    @Test(priority = -1)
    public void test1(){
        Driver.getDriver().get(ConfigReader.getProperty("bankingProjectUrl"));
        bankingProjectPage.clickBankManagerLoginButton();
        bankingProjectPage.clickAddCustomerButton();
    }
    @Test(dataProvider = "getData")
    public void createNewCustomerTest(String firstName, String lastName, String postCode){
        CreateNewCustomerPage createNewCustomerPage=new CreateNewCustomerPage();
        createNewCustomerPage.createNewCustomer(firstName,lastName,postCode);
        Driver.getDriver().switchTo().alert().accept();


    }

    @Test(dataProvider = "getCustomer",dependsOnMethods = "createNewCustomerTest")
    public void openAccountTest(String customer){
        bankingProjectPage.clickOpenAccountButton();
        bankingProjectPage.openAccount(customer);
        Driver.getDriver().switchTo().alert().accept();
    }

    @Test(dependsOnMethods = {"createNewCustomerTest","openAccountTest"})
    public void countTableRowNumbers(){
        bankingProjectPage.clickCustomersButton();
        bankingProjectPage.verifyTheNumberOfNewCustomer(5);
    }
    @Test(dependsOnMethods = {"createNewCustomerTest","openAccountTest","countTableRowNumbers"})
    public void login(){
        bankingProjectPage.Login("Reemah Alnakhebi");
        bankingProjectPage.Login("Harry Potter");
    }

    @Test(dependsOnMethods = {"createNewCustomerTest","openAccountTest","countTableRowNumbers","login"})
    public void depositAndWithdraw(){
        bankingProjectPage.deposit(100);
        bankingProjectPage.withdraw(100);
    }

    @Test(dependsOnMethods = {"createNewCustomerTest","openAccountTest","countTableRowNumbers","login","depositAndWithdraw"})
    public void DeleteAccounts(){
        bankingProjectPage.deleteAllCustomer();
    }

    @DataProvider
    public Object[][] getData(){
        Faker faker =new Faker();

        return new Object[][]{
                {"Reemah","Alnakhebi",faker.address().zipCode()},
                {faker.name().firstName(),faker.name().lastName(),faker.address().zipCode()},
                {faker.name().firstName(),faker.name().lastName(),faker.address().zipCode()},
                {faker.name().firstName(),faker.name().lastName(),faker.address().zipCode()},
                {faker.name().firstName(),faker.name().lastName(),faker.address().zipCode()}
        };
    }
    @DataProvider
    public Object[][] getCustomer(){
        return new Object[][]{
                {"Harry Potter"},
                {"Ron Weasly"},
                {"Hermoine Granger"},
                {"Albus Dumbledore"},
                {"Neville Longbottom"}
        };
    }
}