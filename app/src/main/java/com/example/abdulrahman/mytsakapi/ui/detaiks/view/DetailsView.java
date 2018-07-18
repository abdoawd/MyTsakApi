package com.example.abdulrahman.mytsakapi.ui.detaiks.view;

import android.view.View;

import com.example.abdulrahman.mytsakapi.base.entities.Category;

import java.util.List;

/**
 * Created by abdulrahman on 7/12/2018.
 */

public interface DetailsView {
    String CATEGORY_ARG = "category";

    void showConnectionError(View.OnClickListener onClickListener);

    void setListItems(List<Category> list);

    void hideProgressBar();

    void showProgressBar();

    Category getCategory();

    void setFragmentTitle(String txt);

    void showNoItems();
}
