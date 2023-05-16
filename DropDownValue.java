import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DropDownValue {
        WebDriver driver;

        @BeforeMethod
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\Software\\Browser drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://shop.pragmatic.bg/admin/");
            driver.manage().window().maximize();
        }

        //@AfterMethod
        //public void tearDown() {
        //	driver.quit();
        //}


        @Test
        public void testOrderStatusValue() {
            WebElement Username = driver.findElement(By.id("input-username"));
            WebElement Password = driver.findElement(By.id("input-password"));
            Username.sendKeys("admin");
            Password.sendKeys("parola123!");

            WebElement Login = driver.findElement(By.cssSelector("button[class*='btn btn-primary']"));
            Login.click();

            WebElement Sales = driver.findElement(By.id("menu-sale"));
            Sales.click();

            WebElement Orders = driver.findElement(By.linkText("Orders"));
            Orders.click();

            Select value = new Select(driver.findElement(By.name("filter_order_status_id")));
            //value.selectByValue("0");
            value.selectByVisibleText("Failed");

            assertFalse(value.isMultiple());

            //driver.findElement(By.cssSelector("* input[type=checkbox]:nth-child(4)"));


            }


}



