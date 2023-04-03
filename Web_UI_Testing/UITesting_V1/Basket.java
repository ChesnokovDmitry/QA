package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Basket
{
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
            WebElement webElement1 = driver.findElement(By.xpath(".//div[@class='catalogue-menu-block']/ul/li[2]/a"));
            webElement1.click();

            WebElement webElement2 = driver.findElement(By.xpath(".//div[@class='content-column-right']//a[1]/div[2]"));
            webElement2.click();

            Thread.sleep(3000);

            WebElement webElement3 = driver.findElement(By.xpath(".//div[@class='listing-items-wrap']/div[1]//div[@class='listing-item__addtocart']/span"));
            webElement3.click();

            Thread.sleep(3000);

            WebElement webElement4 = driver.findElement(By.xpath(".//div[@class='popup popup-to-basket']//a[@class='simple-button']"));
            webElement4.click();
        } catch (NoSuchElementException | InterruptedException e) {
            System.out.println("Элемент не найден.");
        }
    }
}
