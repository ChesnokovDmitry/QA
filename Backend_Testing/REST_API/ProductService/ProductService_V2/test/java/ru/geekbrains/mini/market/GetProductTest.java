package ru.geekbrains.mini.market;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetProductTest extends AbstractProductTest {

    @SneakyThrows
    @Test
    void getProductByCriterionPositiveTest() {
        getProductsExample().createCriteria().andIdGreaterThan(1L)
                .andPriceLessThan(50000)
                .andCategory_idEqualTo(2L);

        assertThat(getProductsMapper().selectByExample(getProductsExample()).get(0).getId(), equalTo(4L));
        assertThat(getProductsMapper().selectByExample(getProductsExample()).get(0).getTitle(), is("Samsung Watch X1000"));
    }
}
