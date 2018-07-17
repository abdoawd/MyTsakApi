package com.example.abdulrahman.mytsakapi.ui.home.model;

import com.example.abdulrahman.mytsakapi.base.entities.Category;

import java.util.List;

/**
 * Created by abdulrahman on 7/12/2018.
 */

public interface HomeModel {
    void getCategoriesList(GetCategoriesCallback callback);

    void cancelCategoriesRequest();

    interface GetCategoriesCallback {
        void onGettingCategoriesSuccess(List<Category> categories);

        void onGettingCategoriesFailure();
    }
}
