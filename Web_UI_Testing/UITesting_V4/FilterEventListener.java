package org.example.AllureTest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilterEventListener extends AllureAbstractTest {

    @Test
    @Description("Поиск товара с применением фильтра")
    public void basketTest() {
        FilterPageObject filterPageObject = new FilterPageObject(getWebDriver())
                .clickWebElement1()
                .clickWebElement2()
                .clickWebElement3()
                .clickWebElement4()
                .clickWebElement5()
                .clickWebElement6();
        Assertions.assertEquals("https://www.aqua-shop.ru/akvariumy_i_tumbyu/aquariumy/?volume=do_10&morskie=1&instock=1",
                filterPageObject.getResult());
    }
}
