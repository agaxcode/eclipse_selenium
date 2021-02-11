package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;
import pageobjects.Login;



public class TestLogin {

    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",  "/Users/aga/Documents/Webdriver/88/chromedriver");
        driver = new ChromeDriver();
        login = new Login(driver);
    }

    @Test
    public void succeeded() {
    	login.with("tomsmith", "SuperSecretPassword!");
    	assertTrue("success message not present",
                login.successMessagePresent());
    }
    
    @Test
    public void failed() {
        login.with("tomsmith", "bad password");
        assertFalse("success message was present after providing bogus credentials",
                login.successMessagePresent());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
