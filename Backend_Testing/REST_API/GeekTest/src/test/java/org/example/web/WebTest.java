package org.example.web;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTest extends AbstractWebTest {

    @Test
    public void authorizationPositiveTest() throws InterruptedException {
        WebElement webElement1 = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[1]/label/input"));
        webElement1.sendKeys("GB202301271f419");

        WebElement webElement2 = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[2]/label/input"));
        webElement2.sendKeys("f83466a568");

        WebElement webElement = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[3]/button"));
        webElement.click();

        Thread.sleep(3000);

        Assertions.assertEquals("https://test-stand.gb.ru/admin/student?page=1&limit=10",
                getDriver().getCurrentUrl());
    }

    @Test
    public void authorizationLowerLimitValueTest() throws InterruptedException {
        WebElement webElement1 = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[1]/label/input"));
        webElement1.sendKeys("GB2");

        WebElement webElement2 = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[2]/label/input"));
        webElement2.sendKeys("f83466a568");

        WebElement webElement = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[3]/button"));
        webElement.click();

        Thread.sleep(3000);

        Assertions.assertEquals("401", getDriver()
                .findElement(By.xpath("/html/body/div/main/div/div/div[2]/h2")).getText());
    }

    @Test
    public void authorizationUpperLimitValueTest() throws InterruptedException {
        WebElement webElement1 = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[1]/label/input"));
        webElement1.sendKeys("GB202301271f41916171");

        WebElement webElement2 = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[2]/label/input"));
        webElement2.sendKeys("f83466a568");

        WebElement webElement = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[3]/button"));
        webElement.click();

        Thread.sleep(3000);

        Assertions.assertEquals("401", getDriver()
                .findElement(By.xpath("/html/body/div/main/div/div/div[2]/h2")).getText());
    }

    @Test
    public void authorizationNegative1Test() throws InterruptedException {
        WebElement webElement1 = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[1]/label/input"));
        webElement1.sendKeys("GB");

        WebElement webElement2 = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[2]/label/input"));
        webElement2.sendKeys("f83466a568");

        WebElement webElement = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[3]/button"));
        webElement.click();

        Thread.sleep(3000);

        Assertions.assertEquals("401", getDriver()
                .findElement(By.xpath("/html/body/div/main/div/div/div[2]/h2")).getText());
    }

    @Test
    public void authorizationNegative2Test() throws InterruptedException {
        WebElement webElement1 = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[1]/label/input"));
        webElement1.sendKeys("GB202301271f419161718");

        WebElement webElement2 = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[2]/label/input"));
        webElement2.sendKeys("f83466a568");

        WebElement webElement = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[3]/button"));
        webElement.click();

        Thread.sleep(3000);

        Assertions.assertEquals("401", getDriver()
                .findElement(By.xpath("/html/body/div/main/div/div/div[2]/h2")).getText());
    }

    @Test
    public void authorizationNegative3Test() throws InterruptedException {
        WebElement webElement1 = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[1]/label/input"));
        webElement1.sendKeys("");

        WebElement webElement2 = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[2]/label/input"));
        webElement2.sendKeys("f83466a568");

        WebElement webElement = getDriver().findElement(By.xpath("/html/body/div/main/div/div/div[1]/form/div[3]/button"));
        webElement.click();

        Thread.sleep(3000);

        Assertions.assertEquals("401", getDriver()
                .findElement(By.xpath("/html/body/div/main/div/div/div[2]/h2")).getText());
    }
}
