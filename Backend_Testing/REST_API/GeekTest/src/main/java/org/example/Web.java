package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Web {
    public static void main( String[] args )
    {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://test-stand.gb.ru/login");

        try {
            WebElement webElement1 = driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[1]/label/input"));
            webElement1.sendKeys("GB202301271f419");

            Thread.sleep(3000);

            WebElement webElement2 = driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[2]/label/input"));
            webElement2.sendKeys("f83466a568");

            Thread.sleep(3000);

            WebElement webElement3 = driver.findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[3]/button"));
            webElement3.click();
        } catch (NoSuchElementException | InterruptedException e) {
            System.out.println("Элемент не найден.");
        }
    }
}
