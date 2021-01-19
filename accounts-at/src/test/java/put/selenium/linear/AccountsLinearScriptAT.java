package put.selenium.linear;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import put.selenium.utils.ScreenshotAndQuitOnFailureRule;

import static org.junit.Assert.*;


public class AccountsLinearScriptAT {

    private WebDriver driver;

    @Rule
    public ScreenshotAndQuitOnFailureRule screenshotOnFailureAndWebDriverQuitRule =
            new ScreenshotAndQuitOnFailureRule();


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver-usethisone");
        this.driver = new ChromeDriver();
        screenshotOnFailureAndWebDriverQuitRule.setWebDriver(driver);
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
    }

    @Test
    public void successfulUserRegistration() throws Exception {
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
        driver.get("http://localhost:8080/accounts/controller");
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("Adas");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("jednorozce");
        driver.findElement(By.name("repeat_password")).clear();
        driver.findElement(By.name("repeat_password")).sendKeys("jednorozce");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("Adam W");
        driver.findElement(By.name("addressData")).clear();
        driver.findElement(By.name("addressData")).sendKeys("informatyczna 10");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("jednorozce");
        driver.findElement(By.name("repeat_password")).clear();
        driver.findElement(By.name("repeat_password")).sendKeys("jednorozce");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("Adam W");
        driver.findElement(By.name("addressData")).clear();
        driver.findElement(By.name("addressData")).sendKeys("informatyczna 10");
        driver.findElement(By.name("submit")).click();
        assertEquals("Some values missing!", driver.findElement(By.id("error-message")).getText());
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("Adasa");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("jednorozce");
        driver.findElement(By.name("repeat_password")).clear();
        driver.findElement(By.name("repeat_password")).sendKeys("jednorozce");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("x");
        driver.findElement(By.name("submit")).click();
        assertEquals("Name should have at least two words!", driver.findElement(By.id("error-message")).getText());
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("Adasb");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("jednorozce");
        driver.findElement(By.name("repeat_password")).clear();
        driver.findElement(By.name("repeat_password")).sendKeys("kalamarnice");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("Adam W");
        driver.findElement(By.name("addressData")).clear();
        driver.findElement(By.name("addressData")).sendKeys("informatyczna 10");
        driver.findElement(By.name("submit")).click();
        assertEquals("Passwords don't match!", driver.findElement(By.id("error-message")).getText());
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=username | ]]
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("Adasc");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("jednorozce");
        driver.findElement(By.name("repeat_password")).clear();
        driver.findElement(By.name("repeat_password")).sendKeys("jednorozce");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("x x");
        driver.findElement(By.name("submit")).click();
        assertEquals("Incorrect name. The first and last word should start from a capital letter!", driver.findElement(By.id("error-message")).getText());
    }
    /*
    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
    */
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
