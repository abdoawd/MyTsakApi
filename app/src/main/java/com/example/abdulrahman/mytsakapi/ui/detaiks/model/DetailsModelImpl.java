package com.example.abdulrahman.mytsakapi.ui.detaiks.model;

import com.example.abdulrahman.mytsakapi.base.entities.Category;
import com.example.abdulrahman.mytsakapi.network.ApiClient;
import com.example.abdulrahman.mytsakapi.network.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by abdulrahman on 7/12/2018.
 */

public class DetailsModelImpl implements DetailsModel {

    private Call<List<Category>> subCategoriesRequest;

    @Override
    public void getSubCategories(int catId, final GetSubCategoriesCallback callback) {
        subCategoriesRequest = ApiClient.getApiService().getSubCategories(catId, Constants.COuNTRY_ID);
        subCategoriesRequest.enqueue(new Callback<List<Category>>() {
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
    public void cancelSubCategoriesRequest() {
        if (subCategoriesRequest != null)
            subCategoriesRequest.cancel();
    }
}