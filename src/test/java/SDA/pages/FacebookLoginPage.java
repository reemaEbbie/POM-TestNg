package SDA.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import SDA.utilities.Driver;

import java.time.Duration;

public class FacebookLoginPage {

    public FacebookLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(name = "login")
    WebElement loginButton;
    @FindBy (xpath = "//*[@id='error_box']/div")
    WebElement errorMessage;
    @FindBy (xpath = "//*[@class='_9ay7']")
    WebElement emailExistMessage;
    public void fakerLogin(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    /**
     * there is 2 possibility
     * 1- the entered credentials is wrong
     * 2- The email is linked to existing account but the password is wrong,
     * so we have to locate each cases with different xpath and handle
     * noSuchElementException, because one WebElement will not be located
     */
    public void isErrorMessageDisplayed() {
        try {
            if (errorMessage.isDisplayed()) {
                Assert.assertTrue(errorMessage.getText()
                        .contains("Wrong Credentials"));
            }}catch (NoSuchElementException noSuchElementException){
            noSuchElementException.getMessage();
        }

        try {
            if(emailExistMessage.isDisplayed()){
                Assert.assertTrue(emailExistMessage.getText()
                        .contains("The email you entered isn’t connected to an account.")||
                        emailExistMessage.getText()
                                .contains("The password you’ve entered is incorrect"));
            }}catch (NoSuchElementException noSuchElementException){
            noSuchElementException.getMessage();
        }
    }

}