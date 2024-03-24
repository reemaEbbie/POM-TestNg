package SDA.tests;
public class C01_POMInfo {


    /*
    Page Object Model (POM): It is a model created to facilitate the preparation and execution of our tests
    in a more organized and easy manner. Although there are similar models created for frameworks,
    we learned POM as it is the most up-to-date and widely used model.

    POM file structure:

    Pages: We create a class under the Pages package for the web pages we will test.
    In these classes, the essential step is to take the driver from the Driver class that we created
    and make the initial assignment with PageFactory.initElements. Afterward, we create all
    the WebElements that we will use on the web page as public and locate them with the @FindBy annotation.
    If desired, we can also create methods in this class to perform certain steps such as login.
    We access the variables and methods on the Page from the Test class by creating an object.

    configuration.properties: We use this file to make the data we receive from the user,
    such as the URL and test data, dynamic in our tests.
    We design all our tests based on the data we will receive from this file.
    Thus, by changing a value in this file, we can update the test data for all test cases.
    We design this page like a simple text file, creating each test data with key=value pairs.

    ConfigurationReader: This class acts as a translator between our test class and the configuration.properties file.
    We create a static block inside it to read .properties files. Additionally, we create the getPropert() method
    to call from our test classes. This method retrieves the value corresponding to the key in the configuration.properties
    file with the help of the static block.

    Driver: This class is where we create the driver we will use in our test and page classes.
    It is created under the Utilities package. We can make the Driver class a Singleton.
    We create the driver as static and perform the assignment in the getDriver() method we created.
    */



}