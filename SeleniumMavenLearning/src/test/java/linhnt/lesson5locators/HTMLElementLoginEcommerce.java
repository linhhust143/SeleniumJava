package linhnt.lesson5locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HTMLElementLoginEcommerce {
    public static void main(String[] args) throws InterruptedException {

        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang ecommerce
        driver.get("https://cms.anhtester.com/login");
        Thread.sleep(2000);
        // điền thông tin email- tìm locator theo ID bằng By.id
        driver.findElement(By.id("email")).sendKeys("admin@example.com");

        // điền password - tìm locator theo name bằng By.name
        driver.findElement(By.name("password")).sendKeys("123456");

        // click link text bằng By.linkText
//        driver.findElement(By.linkText("Forgot password ?")).click();
        driver.findElement(By.partialLinkText("password")).click();
        //Tắt browser
        Thread.sleep(2000);
        driver.quit();
    }
}
