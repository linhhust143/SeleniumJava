package linhnt.lesson5locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathLoginHRM {
    public static void main(String[] args) throws InterruptedException {

        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang HRM
        driver.get("https://app.hrsale.com/");
        Thread.sleep(2000);
        // nhập user name bằng xpath
        driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[1]/div[1]/input")).sendKeys("frances.burns");

        // nhập password bằng xpath
        driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[1]/div[2]/input")).sendKeys("frances.burns");

        driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[3]/div[1]/button")).click();

        //Tắt browser
        Thread.sleep(6000);
        driver.quit();
    }
}
