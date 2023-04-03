package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasketTest extends AbstractTest {

    @Test
    public void basketTest() {
        Assertions.assertDoesNotThrow(() -> {
            Actions actions = new Actions(getDriver());
            actions.click(getDriver().findElement(By.xpath(".//div[@class='catalogue-menu-block']/ul/li[2]/a")))
                    .build()
                    .perform();

            WebElement webElement2 = getDriver().findElement(By.cssSelector(".category-menu-item__specification"));
            webElement2.click();
            Thread.sleep(1000);

            WebElement webElement3 = getDriver().findElement(By.xpath(".//span[@pid='17873']"));
            webElement3.click();
            Thread.sleep(1000);

            WebElement webElement4 = getDriver().findElement(By.xpath(".//a[@class='simple-button']"));
            webElement4.click();
            Thread.sleep(1000);
        });

        String text = getDriver().findElement(By.xpath(".//span[@id='basket']")).getText();
        Assertions.assertEquals("1", text);
    }
}
