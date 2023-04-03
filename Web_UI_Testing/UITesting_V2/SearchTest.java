package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchTest extends AbstractTest {

    @Test
    public void searchTest() {
        Assertions.assertDoesNotThrow(() -> {
            WebElement webElement1 = getDriver().findElement(By.xpath(".//input[@id='search_input']"));
            webElement1.sendKeys("фильтры");
            Thread.sleep(1000);

            WebElement webElement2 = getDriver().findElement(By.className("find-button"));
            webElement2.click();
        });

        Assertions.assertEquals("Результаты поиска по запросу \"фильтры\"", getDriver()
                .findElement(By.xpath(".//h1[@class='h1_prodcard']")).getText());
    }
}
