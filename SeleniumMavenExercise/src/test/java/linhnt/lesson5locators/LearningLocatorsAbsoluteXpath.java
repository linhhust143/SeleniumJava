package linhnt.lesson5locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class LearningLocatorsAbsoluteXpath {
    private void login(WebDriver drive) throws InterruptedException {
        final String inputEmail = "/html/body/div/div[2]/form/div[1]/input";
        final String inputPassword = "/html/body/div/div[2]/form/div[2]/input";
        final String btnLogin = "/html/body/div/div[2]/form/div[4]/button";
        drive.findElement(By.xpath(inputEmail)).sendKeys("admin@example.com");
        drive.findElement(By.xpath(inputPassword)).sendKeys("123456");
        drive.findElement(By.xpath(btnLogin)).click();
        Thread.sleep(2000);
    }

    private void createNewCustomer(WebDriver driver) throws InterruptedException {
        final String linkTxtCustomerMenu = "/html/body/aside/ul/li[3]/a";
        final String linkTxtNewCustomer = "/html/body/div[3]/div/div/div/div[2]/a[1]";
        final String inputCompany = "/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[1]/input";
        final String inputVATNumber = "/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[3]/input";
        final String inputPhone = "/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[4]/input";
        final String inputWebsite = "/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[5]/input";
        final String selectGroups = "/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[6]/div/div[1]/button/div/div/div";
        final String selectCurrency = "/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[7]/div[1]/div/div/button/div/div/div";
        final String selectDefaultLanguage = "/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[7]/div[2]/div/div/button/div/div/div";
        final String inputAddress = "/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[8]/textarea";
        final String inputCity = "/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[9]/input";
        final String inputState = "/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[10]/input";
        final String inputZipCode = "/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[11]/input";
        final String selectCountry = "/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[12]/div/button/div/div/div";
        final String btnSaveAndCreateContact = "/html/body/div[3]/div/div/div[3]/div/div[2]/button[1]";

        // click customer menu
        driver.findElement(By.xpath(linkTxtCustomerMenu)).click();
        Thread.sleep(2000);

        // click New Customer button
        driver.findElement(By.xpath(linkTxtNewCustomer)).click();
        Thread.sleep(2000);

        // Fill in the new customer information
        driver.findElement(By.xpath(inputCompany)).sendKeys("Apple");
        driver.findElement(By.xpath(inputVATNumber)).sendKeys("VAT001");
        driver.findElement(By.xpath(inputPhone)).sendKeys("0123456789");
        driver.findElement(By.xpath(inputWebsite)).sendKeys("https://www.apple.com/vn/");
        Select sltGroups = new Select(driver.findElement(By.xpath(selectGroups)));
        sltGroups.selectByIndex(3);

        Select sltCurrency = new Select(driver.findElement(By.xpath(selectCurrency)));
        sltCurrency.selectByIndex(1);

        Select sltDefaultLanguage = new Select(driver.findElement(By.xpath(selectDefaultLanguage)));
        sltDefaultLanguage.selectByValue("English");


        driver.findElement(By.xpath(inputAddress)).sendKeys("Cupertino");
        driver.findElement(By.xpath(inputCity)).sendKeys("California");
        driver.findElement(By.xpath(inputState)).sendKeys("United States");
        driver.findElement(By.xpath(inputZipCode)).sendKeys("90001");
        Select sltCountry = new Select(driver.findElement(By.xpath(selectCountry)));
        sltCountry.selectByValue("Vietnam");

        Thread.sleep(6000);
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        driver.get("https://crm.anhtester.com/admin/authentication");

        // login by username password
        LearningLocatorsAbsoluteXpath locators = new LearningLocatorsAbsoluteXpath();
        locators.login(driver);
        locators.createNewCustomer(driver);

        Thread.sleep(2000);
        driver.quit();
    }
}
