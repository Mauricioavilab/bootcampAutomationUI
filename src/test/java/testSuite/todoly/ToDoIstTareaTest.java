package testSuite.todoly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ToDoIstTareaTest {
    WebDriver driver;
    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
        // implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // page load wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.get("https://todoist.com/");
    }
    @Test
    public void createTareaTest() throws InterruptedException {

        //Login
        driver.findElement(By.xpath("/html/body/div/div/div/header/nav[2]/div/ul[2]/li[1]/a")).click();
        driver.findElement(By.id("element-0")).sendKeys("mauricio.avilax@gmail.com");
        driver.findElement(By.id("element-3")).sendKeys("Admin123*2021*#");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/form/button")).click();
        //test
        driver.findElement(By.id("quick_add_task_holder")).click();
        driver.findElement(By.xpath("/html/body/reach-portal/div[2]/div/div/div[2]/div/section/form/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div/div")).sendKeys("newtask");
        driver.findElement(By.xpath("/html/body/reach-portal/div[2]/div/div/div[2]/div/section/form/div[2]/div/div/button[2]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/main/div/div[2]/div/div[2]/ul/li[3]/div/ul/li[4]/div/div[3]/button[3]")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/ul/li[1]/div[2]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/main/div/div[2]/div/div[2]/ul/li[3]/div/ul/li[4]/form/div[1]/div[1]/div[1]/div/div/div/div/div/div/div")).sendKeys("edited");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/main/div/div[2]/div/div[2]/ul/li[3]/div/ul/li[4]/form/div[2]/div/div/button[2]")).click();


    }


}
