package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Filter {
    public static void main( String[] args )
    {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.aqua-shop.ru/");

        try {
            WebElement webElement1 = driver.findElement(By.xpath(".//ul[@id='catalogue-menu']/li[2]/a"));
            webElement1.click();

            Thread.sleep(2000);

            WebElement webElement2 = driver.findElement(By.linkText("Аквариумы"));
            webElement2.click();

            Thread.sleep(2000);

            WebElement webElement3 = driver.findElement(By.xpath(".//div[@class='checkbox_item']//label"));
            webElement3.click();

            WebElement webElement4 = driver.findElement(By.xpath(".//div[@class='checkbox_item']//label[@for='do_10']"));
            webElement4.click();

            WebElement webElement5 = driver.findElement(By.xpath(".//div[@class='checkbox_item']//label[@for='morskie']"));
            webElement5.click();

            Thread.sleep(2000);

            WebElement webElement6 = driver.findElement(By.xpath(".//input[@value='Показать выбранное']"));
            webElement6.click();
        } catch (NoSuchElementException | InterruptedException e) {
            System.out.println("Элемент не найден.");
        }
    }
}
