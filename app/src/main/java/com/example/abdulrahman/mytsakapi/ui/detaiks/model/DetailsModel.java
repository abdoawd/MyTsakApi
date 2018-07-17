package com.example.abdulrahman.mytsakapi.ui.detaiks.model;

import com.example.abdulrahman.mytsakapi.base.entities.Category;

import java.util.List;

/**
 * Created by abdulrahman on 7/12/2018.
 */

public interface DetailsModel {
    void getSubCategories(int catId, GetSubCategoriesCallback callback);

    void cancelSubCategoriesRequest();

    interface GetSubCategoriesCallback {
        void onGettingCategoriesSuccess(List<Category> categories);

        void onGettingCategoriesFailure();
    }
}
