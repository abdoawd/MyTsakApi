package com.example.abdulrahman.mytsakapi.network;


import com.example.abdulrahman.mytsakapi.base.entities.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by abdulrahman on 5/9/2018.
 */

public interface ApiService {

    @GET("GetCategories?categoryId=0&countryId=1")
    Call<List<Category>> getMainCategories();

    @GET("GetCategories")
    Call<List<Category>> getSubCategories(@Query("categoryId") int categoryId, @Query("countryId") int countryId);

}
