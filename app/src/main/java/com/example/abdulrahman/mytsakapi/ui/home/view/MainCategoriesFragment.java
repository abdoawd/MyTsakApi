package com.example.abdulrahman.mytsakapi.ui.home.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.abdulrahman.mytsakapi.R;
import com.example.abdulrahman.mytsakapi.base.entities.Category;
import com.example.abdulrahman.mytsakapi.ui.detaiks.view.FragmentSubCategories;
import com.example.abdulrahman.mytsakapi.ui.home.pressenter.HomePresenter;
import com.example.abdulrahman.mytsakapi.ui.home.pressenter.HomePresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by abdulrahman on 7/12/2018.
 */

public class MainCategoriesFragment extends Fragment implements HomeView {

    @BindView(R.id.rv_main)
    RecyclerView recyclerView;

    @BindView(R.id.main_fragment_constraint)
    ConstraintLayout constraintLayout;

    @BindView(R.id.progressBar_main)
    ProgressBar progressBar;

    private CategoriesAdapter adapter;
    private HomePresenter presenter;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_categories, container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new HomePresenterImpl(this);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new CategoriesAdapter(this);
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
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void setListItems(List<Category> list) {
        progressBar.setVisibility(View.GONE);
        adapter.setItems(list);

    }

    public void addDetailsFragment(Category category) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer, FragmentSubCategories.getInstance(category));
        fragmentTransaction.addToBackStack("details");
        fragmentTransaction.commit();
    }

    @Override
    public void onDestroy() {
        presenter.clear();
        unbinder.unbind();
        super.onDestroy();
    }

    public static MainCategoriesFragment getInstance() {
        return new MainCategoriesFragment();
    }
}
