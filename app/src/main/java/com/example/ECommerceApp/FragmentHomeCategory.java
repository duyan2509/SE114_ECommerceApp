package com.example.ECommerceApp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ECommerceApp.Adapter.CategoryAdapter;
import com.example.ECommerceApp.Adapter.ProductAdapter;
import com.example.ECommerceApp.Model.Category;
import com.example.ECommerceApp.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class FragmentHomeCategory extends Fragment {
    private RecyclerView rcvCategory;
    private List<Category> mListCategory;
    private CategoryAdapter categoryAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_home, container, false);
        rcvCategory = rootView.findViewById(R.id.rcvCategory);
        mListCategory = new ArrayList<>();
        mListCategory.add(new Category(R.drawable.category_clothes, "CLOTHES", "101 products"));
        mListCategory.add(new Category(R.drawable.category_book, "BOOK", "125 products"));
        mListCategory.add(new Category(R.drawable.category_sneaker, "SNEAKER", "153 products"));
        mListCategory.add(new Category(R.drawable.category_bag, "BAG", "95 products"));
        mListCategory.add(new Category(R.drawable.category_jewelry, "JEWELRY", "57 products"));
        mListCategory.add(new Category(R.drawable.category_electronics, "ELECTRONICS", "146 products"));

        // Tạo và cài đặt Adapter cho RecyclerView
        categoryAdapter = new CategoryAdapter(mListCategory);

        // Thiết lập LayoutManager cho RecyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvCategory.setLayoutManager(linearLayoutManager);
        rcvCategory.setAdapter(categoryAdapter);
        return rootView;
    }
}