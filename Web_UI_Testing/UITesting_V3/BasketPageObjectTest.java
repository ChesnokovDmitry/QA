package org.example.PageFactoryTest;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BasketPageObjectTest extends AbstractPageObjectTest {

    @Test
    public void basketTest() {
        BasketPageObject basketPageObject = new BasketPageObject(getDriver())
                .clickWebElement1()
                .clickWebElement2()
                .clickWebElement3()
                .clickWebElement4();
        Assertions.assertEquals("1", basketPageObject.getResult());
    }
}
