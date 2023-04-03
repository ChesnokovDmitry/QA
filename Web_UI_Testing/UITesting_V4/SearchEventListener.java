package org.example.AllureTest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchEventListener extends AllureAbstractTest {

    @Test
    @Description("Поиск товара")
    public void basketTest() {
        SearchPageObject searchPageObject = new SearchPageObject(getWebDriver())
                .sendKeysWebElement1()
                .clickWebElement2();
        Assertions.assertEquals("Результаты поиска по запросу \"фильтры\"", searchPageObject.getResult());
    }
}
