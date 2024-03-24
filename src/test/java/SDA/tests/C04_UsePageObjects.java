package SDA.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import SDA.pages.sauceDemo.InventoryPage;
import SDA.pages.sauceDemo.LoginPage;
import SDA.utilities.ConfigReader;
import SDA.utilities.Driver;

public class C04_UsePageObjects {
    /*
    Navigate to https://www.saucedemo.com/
Enter the user name as standard_user
Enter the password as secret_sauce
Click on login button.
- Choose price low to high with soft Assert.
- Verify item prices are sorted from low to high with hard Assert.

     */
    @Test
    public void pageObjectsTest(){
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        //   Navigate to https://www.saucedemo.com/
        Driver.getDriver().get(ConfigReader.getProperty("sauceDemoUrl"));

        //   Enter the username as standard_user
        loginPage.usernameField.sendKeys(ConfigReader.getProperty("sauceDemoUsername"));

        //   Enter the password as secret_sauce
        loginPage.passwordField.sendKeys(ConfigReader.getProperty("sauceDemoPassword"));

        //   Click on login button.
        loginPage.loginButton.click();

        //   - Choose price low to high .

        inventoryPage.selectByIndex(2);
        //inventoryPage.selectByVisibleText("Price (low to high)");
        String optionText = inventoryPage.getTextOfSelectedOption();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(optionText.contains("low to high"));
        softAssert.assertAll();

        // Verify item prices are sorted from low to high with hard Assert.
        Assert.assertTrue(optionText.contains("low to high"));

        Driver.closeDriver();
    }

}