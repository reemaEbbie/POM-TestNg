package SDA.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SDA.utilities.Driver;

public class DhtmlgoodiesPage {

    public DhtmlgoodiesPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//div[text()='Spain']")
    WebElement Spain;
    @FindBy(xpath = "//div[text()='United States']")
    WebElement UnitedStates;
    @FindBy(xpath = "//div[text()='Italy']")
    WebElement Italy;
    @FindBy(xpath = "//div[text()='South Korea']")
    WebElement SouthKorea;
    @FindBy(xpath = "//div[text()='Denmark']")
    WebElement Denmark;
    @FindBy(xpath = "//div[text()='Norway']")
    WebElement Norway;
    @FindBy(xpath = "//div[text()='Sweden']")
    WebElement Sweden;

    @FindBy(xpath = "//div[text()='Madrid'][2]")
    WebElement Madrid;
    @FindBy(xpath = "//div[text()='Washington'][2]")
    WebElement Washington;
    @FindBy(xpath = "//div[text()='Rome'][2]")
    WebElement Rome;
    @FindBy(xpath = "//div[text()='Seoul'][2]")
    WebElement Seoul;
    @FindBy(xpath = "//div[text()='Copenhagen'][2]")
    WebElement Copenhagen;
    @FindBy(xpath = "//div[text()='Oslo'][2]")
    WebElement Oslo;
    @FindBy(xpath = "//div[text()='Stockholm'][2]")
    WebElement Stockholm;

    public void dragCapitolInCountryBoxInTheirPlaces(String capitol, String country){

        WebElement dragCapitol = null;

        switch (capitol.toLowerCase()){
            case "madrid":
                dragCapitol=Madrid;
                break;
            case "washington":
                dragCapitol=Washington;
                break;
            case "rome":
                dragCapitol=Rome;
                break;
            case "seoul":
                dragCapitol=Seoul;
                break;
            case "copenhagen":
                dragCapitol=Copenhagen;
                break;
            case "oslo":
                dragCapitol=Oslo;
                break;
            case "stockholm":
                dragCapitol=Stockholm;
                break;
            default:
                System.out.println("The capital doesn't exist");

        }


        Actions actions=new Actions(Driver.getDriver());
        switch (country.toLowerCase()){
            case "spain":
                actions.dragAndDrop(dragCapitol, Spain).perform();
                break;
            case "united states":
                actions.dragAndDrop(dragCapitol, UnitedStates).perform();
                break;
            case "italy":
                actions.dragAndDrop(dragCapitol, Italy).perform();
                break;
            case "south korea":
                actions.dragAndDrop(dragCapitol, SouthKorea).perform();
                break;
            case "denmark":
                actions.dragAndDrop(dragCapitol, Denmark).perform();
                break;
            case "norway":
                actions.dragAndDrop(dragCapitol, Norway).perform();
                break;
            case "sweden":
                actions.dragAndDrop(dragCapitol, Sweden).perform();
                break;
            default:
                System.out.println("The country doesn't exist");
        }
    }

}