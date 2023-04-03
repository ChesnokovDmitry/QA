package ru.geekbrains.mini.market.ProductService_V1.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import ru.geekbrains.mini.market.ProductService_V1.dto.Product;

public interface ProductService {
    @GET("products")
    Call<ResponseBody> returnsProducts();

    @GET("products/{id}")
    Call<Product> returnProductId(@Path("id") int id);

    @PUT("products")
    Call<Product> modifyProduct(@Body Product modifyProduct);

    @POST("products")
    Call<Product> createProduct(@Body Product createProductRequest);

    @DELETE("products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") int id);
}
