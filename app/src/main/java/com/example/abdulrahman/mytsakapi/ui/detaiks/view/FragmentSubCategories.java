package com.example.abdulrahman.mytsakapi.ui.detaiks.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.abdulrahman.mytsakapi.R;
import com.example.abdulrahman.mytsakapi.base.entities.Category;
import com.example.abdulrahman.mytsakapi.ui.detaiks.pressenter.DetailsPresenter;
import com.example.abdulrahman.mytsakapi.ui.detaiks.pressenter.DetailsPresenterImpl;
import com.example.abdulrahman.mytsakapi.ui.home.view.CategoriesAdapter;
import com.example.abdulrahman.mytsakapi.ui.home.view.MainActivity;
import com.example.abdulrahman.mytsakapi.utils.TextUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by abdulrahman on 7/15/2018.
 */

public class FragmentSubCategories extends Fragment implements DetailsView {

    @BindView(R.id.imv_toolbar)
    ImageView imgToolbar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;

    @BindView(R.id.rv_fragment_sub_categories)
    RecyclerView recyclerView;

    @BindView(R.id.subcategories_fragment_constraint)
    ConstraintLayout constraintLayout;

    @BindView(R.id.progressBar_sub)
    ProgressBar progressBar;

    private DetailsPresenter presenter;
    private CategoriesAdapter adapter;
    private Unbinder unbinder;
    private Category category;
    private MainActivity activity;

    public static FragmentSubCategories getInstance(Category category) {
        FragmentSubCategories fragmentSubCategories = new FragmentSubCategories();
        Bundle arg = new Bundle();
        arg.putParcelable(CATEGORY_ARG, category);
        fragmentSubCategories.setArguments(arg);
        return fragmentSubCategories;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_categoris, container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (MainActivity) getActivity();
        Bundle bundle = getArguments();
        if (bundle == null || !bundle.containsKey(CATEGORY_ARG)) {
            getFragmentManager().popBackStackImmediate();
            return;
        }

        activity.setSupportActionBar(toolbar);

        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true); // enable back btn
        activity.getSupportActionBar().setDisplayShowHomeEnabled(true);


        presenter = new DetailsPresenterImpl(this);
        category = bundle.getParcelable(CATEGORY_ARG);
        imgToolbar.setVisibility(View.GONE);
        tvToolbar.setVisibility(View.VISIBLE);

        TextUtils.setMontserratTypeFace(tvToolbar);        // set typeface

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new CategoriesAdapter();
        recyclerView.setAdapter(adapter);
        presenter.init();
    }


    @Override
    public void showConnectionError(View.OnClickListener onClickListener) {
        Snackbar.make(constraintLayout, R.string.connection_eror, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.retry, onClickListener)
                .show();
    }


    @Override
    public void setListItems(List<Category> items) {
        adapter.setItems(items);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void setFragmentTitle(String txt) {
        tvToolbar.setText(txt);
    }


    @Override
    public void onDestroy() {
        presenter.clear();
        unbinder.unbind();
        super.onDestroy();
    }
}
