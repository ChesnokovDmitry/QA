package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FilterTest extends AbstractTest {

    @Test
    public void filterTest() {
        Assertions.assertDoesNotThrow(() -> {
            WebElement webElement1 = getDriver().findElement(By.xpath(".//ul[@id='catalogue-menu']/li[2]/a"));
            webElement1.click();
            Thread.sleep(1000);

            WebElement webElement2 = getDriver().findElement(By.linkText("Аквариумы"));
            webElement2.click();
            Thread.sleep(1000);

            Actions actions = new Actions(getDriver());
            actions.click(getDriver().findElement(By.xpath(".//div[@class='checkbox_item']//label")))
                    .build()
                    .perform();

            WebElement webElement4 = getDriver().findElement(By.xpath(".//div[@class='checkbox_item']//label[@for='do_10']"));
            webElement4.click();
            WebElement webElement5 = getDriver().findElement(By.xpath(".//div[@class='checkbox_item']//label[@for='morskie']"));
            webElement5.click();
            Thread.sleep(1000);

            WebElement webElement6 = getDriver().findElement(By.xpath(".//input[@value='Показать выбранное']"));
            webElement6.click();
        });

        Assertions.assertEquals("https://www.aqua-shop.ru/akvariumy_i_tumbyu/aquariumy/?volume=do_10&morskie=1&instock=1",
                getDriver().getCurrentUrl());
    }
}
