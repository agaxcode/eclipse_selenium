package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestLocator {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/aga/Documents/Webdriver/88/chromedriver");
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setHeadless(true);
        driver = new ChromeDriver(browserOptions);
    }

    @Test
    public void locator_test() {
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        driver.findElement(By.cssSelector(".button.success")).click(); //add here
        driver.findElement(By.cssSelector(".button")).click(); //add here

        // Return the text of the red button id=button alert contains 'foo', 'bar', 'baz', or 'qux'
        String redButtonMessage = driver.findElement(By.cssSelector(".button.alert")).getText(); //add here
        System.out.println("The button reads: " + redButtonMessage);

}

    @After
    public void tearDown() {
        driver.quit();
    }
}