package com.example.abdulrahman.mytsakapi.ui.home.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdulrahman.mytsakapi.R;
import com.example.abdulrahman.mytsakapi.applicatoin.App;
import com.example.abdulrahman.mytsakapi.base.entities.Category;
import com.example.abdulrahman.mytsakapi.utils.ImageUtils;
import com.example.abdulrahman.mytsakapi.utils.LanguageUtils;
import com.example.abdulrahman.mytsakapi.utils.TextUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by abdulrahman on 6/4/2018.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private List<Category> items;
    private MainCategoriesFragment fragment;

    public CategoriesAdapter(MainCategoriesFragment fragment) {
        items = new ArrayList<>();
        this.fragment = fragment;
    }

    public CategoriesAdapter() {
        items = new ArrayList<>();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = items.get(position);
        holder.tvCategoryName.setText(LanguageUtils.isArabicLanguage() ? category.getTitleAR() : category.getTitleEN());
        holder.tvCategoryCount.setText(String.format(App.getContext().getString(R.string.cat_count), category.getProductCount()));
        ImageUtils.loadImage(holder.imvHome, category.getPhoto());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Category> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    private boolean isDetailsAdapter() {
        return fragment == null;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.imv_main_recycler)
        ImageView imvHome;

        @BindView(R.id.tv_main_recycler_title)
        TextView tvCategoryName;

        @BindView(R.id.tv_main_recycler_product_count)
        TextView tvCategoryCount;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            TextUtils.setMontserratTypeFace(tvCategoryCount);
            TextUtils.setMediumTypeFace(tvCategoryName);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (isDetailsAdapter()) {
                return;
            }
            if (getAdapterPosition() < 0) {
                return;
            }
            fragment.addDetailsFragment(items.get(getAdapterPosition()));
        }

    }
}
