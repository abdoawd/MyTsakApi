package com.example.abdulrahman.mytsakapi.ui.home.view;

import android.view.View;

import com.example.abdulrahman.mytsakapi.base.entities.Category;

import java.util.List;

/**
 * Created by abdulrahman on 7/12/2018.
 */

public interface HomeView {
    void showConnectionError(View.OnClickListener onClickListener);

    void setListItems(List<Category> list);


    void hideProgressBar();

    void showProgressBar();

}
