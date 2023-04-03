package org.example.AllureTest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketEventListener extends AllureAbstractTest {

    @Test
    @Description("Добавление товара в корзину")
    public void basketTest() {
        BasketPageObject basketPageObject = new BasketPageObject(getWebDriver())
                .clickWebElement1()
                .clickWebElement2()
                .clickWebElement3()
                .clickWebElement4();
        Assertions.assertEquals("1", basketPageObject.getResult());
    }
}
