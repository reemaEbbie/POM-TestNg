package SDA.tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import SDA.pages.EBayPage;
import SDA.utilities.ConfigReader;
import SDA.utilities.Driver;

public class C08_EbayTest {

    @Test(dataProvider = "getData")
    public void test(String searchKey,int quantity) throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("ebayUrl"));

        EBayPage eBayPage=new EBayPage();
        eBayPage.searchFor(searchKey);
        eBayPage.addFirstItem();
        eBayPage.increaseQuantity(quantity);

        Driver.closeDriver();

    }
    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"book",3},
                {"Mirror",2},
                {"black pen",4}
        };

    }
}