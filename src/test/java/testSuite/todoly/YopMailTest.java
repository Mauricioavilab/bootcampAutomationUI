package testSuite.todoly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YopMailTest {
    WebDriver driver;
    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
        // implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // page load wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.get("https://yopmail.com/");
    }
    @Test
    public void sendEmailTest(){

        driver.findElement(By.id("login")).sendKeys("mauriciox@mail.com");
        driver.findElement(By.xpath("//*[@id=\"refreshbut\"]/button")).click();
        driver.findElement(By.id("newmail")).click();
        driver.switchTo().frame("ifmail");
        driver.findElement(By.id("msgto")).sendKeys("mauriciox@yopmail.com");
        driver.findElement(By.id("msgsubject")).sendKeys("testmailmau");
        driver.findElement(By.id("msgbody")).sendKeys("pruebamail");
        driver.findElement(By.id("msgsend")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.id("refresh")).click();
        driver.switchTo().frame("ifinbox");



    }


}
