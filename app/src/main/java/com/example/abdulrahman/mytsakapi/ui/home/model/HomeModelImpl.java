package com.example.abdulrahman.mytsakapi.ui.home.model;

import com.example.abdulrahman.mytsakapi.base.entities.Category;
import com.example.abdulrahman.mytsakapi.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by abdulrahman on 7/12/2018.
 */

public class HomeModelImpl implements HomeModel {

    private Call<List<Category>> call;

    @Override
    public void getCategoriesList(final GetCategoriesCallback callback) {
        call = ApiClient.getApiService().getMainCategories();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {
                    callback.onGettingCategoriesSuccess(response.body());
                } else {
                    callback.onGettingCategoriesFailure();
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                callback.onGettingCategoriesFailure();
            }
        });
    }

    @Override
    public void cancelCategoriesRequest() {
        if (call != null)
            call.cancel();

    }
}