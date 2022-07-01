import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SeleniumTest {
    public static WebDriver myBrowser;
    @BeforeTest
    public void init(){
        WebDriverManager.chromedriver().setup();
        myBrowser = new ChromeDriver();
        myBrowser.manage().window().maximize();
        myBrowser.get("http://localhost:8084/selenium/");
    }
    @Test
    public static void testcaseLogin(){
        WebElement userID = myBrowser.findElement(By.name("userID"));
        userID.sendKeys("admin");
        WebElement password = myBrowser.findElement(By.name("password"));
        password.sendKeys("123");
        WebElement action = myBrowser.findElement(By.name("action"));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        action.click();
        WebElement h1 = myBrowser.findElement(By.tagName("h1"));
        String h2 = "Welcome: Team 3 - SE1622";
        Assert.assertEquals( h1.getText(), h2);
    }
    //    Test Case 1
    @Test
    public static void testcaseUTCID01() {

        WebElement day = myBrowser.findElement(By.name("day"));
        day.sendKeys("29");
        WebElement month = myBrowser.findElement(By.name("month"));
        month.sendKeys("02");
        WebElement year = myBrowser.findElement(By.name("year"));
        year.sendKeys("2000");

        WebElement check = myBrowser.findElement(By.xpath("/html/body/section/div[4]/div[6]/div/form[2]/div[4]/input[1]"));
        check.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        WebElement valid = myBrowser.findElement(By.xpath("/html/body/section/div[4]/div[6]/div/font[1]"));
        String value = valid.getText();
        Assert.assertEquals(value, "Valid Date!!!");

    }

//    Test Case 2
    @Test
    public static void testcaseUTCID02() {

        WebElement day = myBrowser.findElement(By.name("day"));
        day.clear();
        day.sendKeys("29");
        WebElement month = myBrowser.findElement(By.name("month"));
        month.clear();
        month.sendKeys("15");
        WebElement year = myBrowser.findElement(By.name("year"));
        year.clear();
        year.sendKeys("2018");

        WebElement check = myBrowser.findElement(By.xpath("/html/body/section/div[4]/div[6]/div/form[2]/div[4]/input[1]"));
        check.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        WebElement valid = myBrowser.findElement(By.xpath("/html/body/section/div[4]/div[6]/div/font[1]"));
        String value = valid.getText();
        Assert.assertEquals(value, "Invalid Date!!!");
    }

    //Test Case 3
    @Test
    public static void testcaseUTCID03() {

        WebElement day = myBrowser.findElement(By.name("day"));
        day.clear();
        day.sendKeys("31");
        WebElement month = myBrowser.findElement(By.name("month"));
        month.clear();
        month.sendKeys("2");
        WebElement year = myBrowser.findElement(By.name("year"));
        year.clear();
        year.sendKeys("2021");

        WebElement check = myBrowser.findElement(By.xpath("/html/body/section/div[4]/div[6]/div/form[2]/div[4]/input[1]"));
        check.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        WebElement valid = myBrowser.findElement(By.xpath("/html/body/section/div[4]/div[6]/div/font[1]"));
        String value = valid.getText();
        Assert.assertEquals(value, "Invalid Date!!!");
    }

    @AfterTest
    public void tearDown(){
    //end browser
        myBrowser.quit();
    }

    public static boolean isLeap(int y) {
        boolean result = false;
        if ((y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))) {
            result = true;
        }
        return result;
    }

    public static boolean validDate(int y, int m, int d) {
        if (y < 1 || m < 1 || m > 12 || d < 1 || d > 31) {
            return false;
        }
        int maxD = 31;
        if (m == 4 || m == 6 || m == 9 || m == 11)
           {
            maxD = 30;
        } else if (m == 2) {
            if (isLeap(y)) {
                maxD = 29;
            } else {
                maxD = 28;
            }
        }
        return d <= maxD;
    }

}
