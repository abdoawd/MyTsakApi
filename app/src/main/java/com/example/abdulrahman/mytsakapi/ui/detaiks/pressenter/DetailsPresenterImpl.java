package com.example.abdulrahman.mytsakapi.ui.detaiks.pressenter;

import android.view.View;

import com.example.abdulrahman.mytsakapi.base.entities.Category;
import com.example.abdulrahman.mytsakapi.ui.detaiks.model.DetailsModel;
import com.example.abdulrahman.mytsakapi.ui.detaiks.model.DetailsModelImpl;
import com.example.abdulrahman.mytsakapi.ui.detaiks.view.DetailsView;
import com.example.abdulrahman.mytsakapi.utils.LanguageUtils;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by abdulrahman on 7/15/2018.
 */

public class DetailsPresenterImpl implements DetailsPresenter, DetailsModel.GetSubCategoriesCallback {
    private WeakReference<DetailsView> viewReference;
    private DetailsModel model;

    public DetailsPresenterImpl(DetailsView view) {
        this.viewReference = new WeakReference<>(view);
        model = new DetailsModelImpl();
    }

    @Override
    public void init() {
        getView().setFragmentTitle(LanguageUtils.isArabicLanguage()
                ? getView().getCategory().getTitleAR() : getView().getCategory().getTitleEN());

        getCategoryDetails();
    }

    private void getCategoryDetails() {
        getView().showProgressBar();
        model.getSubCategories(Integer.valueOf(getView().getCategory().getId()), this);
    }


    @Override
    public void clear() {
        model.cancelSubCategoriesRequest();
        viewReference.clear();
        viewReference = null;
    }

    @Override
    public void onGettingCategoriesSuccess(List<Category> categories) {
        if (isViewCleared()) {
            return;
        }
        getView().hideProgressBar();
        if (categories.isEmpty()) {
            getView().showNoItems();
        } else {
            getView().setListItems(categories);
        }

    }

    @Override
    public void onGettingCategoriesFailure() {
        if (isViewCleared()) {
            return;
        }
        getView().hideProgressBar();
        getView().showConnectionError(onRetryBtnClicked());
    }

    private View.OnClickListener onRetryBtnClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCategoryDetails();
            }
        };
    }

    private boolean isViewCleared() {
        return viewReference == null;
    }

    private DetailsView getView() {
        return viewReference.get();
    }
}
