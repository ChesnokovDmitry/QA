package ru.geekbrains.mini.market.ProductService_V1.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.geekbrains.mini.market.ProductService_V1.dto.GetCategoryResponse;

public interface CategoryService {
    @GET("categories/{id}")
    Call<GetCategoryResponse> getCategory(@Path("id") int id);
}
