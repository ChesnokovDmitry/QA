package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class LoginTest extends AbstractTest {

    @Test
    public void loginTest() {
        Assertions.assertDoesNotThrow(() -> {
            WebElement webElement1 = getDriver().findElement(By.className("_account"));
            webElement1.click();

            Actions actions = new Actions(getDriver());
            actions.click(getDriver().findElement(By.id("email_address")))
                    .sendKeys("dmitrijchesy@ya.ru")
                    .click(getDriver().findElement(By.id("password")))
                    .sendKeys("qwertyuiop")
                    .pause(Duration.ofSeconds(2))
                    .build()
                    .perform();

            WebElement webElement4 = getDriver().findElement(By.xpath(".//input[@value='Войти']"));
            webElement4.click();
        });

        Assertions.assertEquals("https://www.aqua-shop.ru/account.php",
                getDriver().getCurrentUrl());
    }
}
