package ru.geekbrains.mini.market.ProductService_V1Test;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.geekbrains.mini.market.ProductService_V1.dto.Product;
import ru.geekbrains.mini.market.ProductService_V1.service.ProductService;
import ru.geekbrains.mini.market.ProductService_V1.util.RetrofitUtils;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ModifyProductTest {
    static ProductService productService;
    Product product = null;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils
                .getRetrofit()
                .create(ProductService.class);
    }

    @BeforeEach
    void setUp() throws IOException {
        Response<Product> response = productService
                .returnProductId(1)
                .execute();

        product = response.body()
                .withTitle("Borjomi")
                .withPrice(130)
                .withCategoryTitle("Food");
    }

    @Test
    @SneakyThrows
    void createProductInFoodCategoryTest() {
        Response<Product> response = productService
                .modifyProduct(product)
                .execute();

        assertThat(response.body().getTitle(), equalTo("Borjomi"));
        assertThat(response.body().getPrice(), equalTo(130));
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));
    }

}
