package ru.geekbrains.mini.market.ProductService_V1Test;

import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.geekbrains.mini.market.ProductService_V1.dto.Product;
import ru.geekbrains.mini.market.ProductService_V1.service.ProductService;
import ru.geekbrains.mini.market.ProductService_V1.util.RetrofitUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetProductTest {
    static ProductService productService;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils
                .getRetrofit()
                .create(ProductService.class);
    }

    @SneakyThrows
    @Test
    void getProductIdPositiveTest() {
        Response<Product> response = productService
                .returnProductId(1)
                .execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(1));
        assertThat(response.body().getTitle(), equalTo("Milk"));
        assertThat(response.body().getPrice(), notNullValue());
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));
    }

    @SneakyThrows
    @Test
    void getProductsPositiveTest() {
        Response<ResponseBody> response = productService
                .returnsProducts()
                .execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.headers().get("content-type"), CoreMatchers.is("application/json"));
    }
}
