package org.example.PageFactoryTest;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FilterPageObjectTest extends AbstractPageObjectTest {

    @Test
    public void basketTest() {
        FilterPageObject filterPageObject = new FilterPageObject(getDriver())
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
