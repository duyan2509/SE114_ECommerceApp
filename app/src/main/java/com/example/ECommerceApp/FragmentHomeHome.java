package com.example.ECommerceApp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.ECommerceApp.adapter.ProductAdapter;
import com.example.ECommerceApp.model.Product;

import java.util.ArrayList;
import java.util.List;


public class FragmentHomeHome extends Fragment {

    private RecyclerView rcvProduct, rcvFavorite;
    private List<Product> productList;
    private ProductAdapter productAdapter;
    private ImageSlider imageSlider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home_home, container, false);

        // Ánh xạ ImageSlider từ layout XML
        imageSlider = rootView.findViewById(R.id.slider);

        // Tạo danh sách SlideModel
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.imgslider1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgslider2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgslider3, ScaleTypes.FIT));

        // Thiết lập danh sách SlideModel cho ImageSlider
        imageSlider.setImageList(slideModels);

        // Ánh xạ RecyclerView từ layout XML
        rcvProduct = rootView.findViewById(R.id.rcvProduct);
        rcvFavorite = rootView.findViewById(R.id.rcvFavorite);

        // Tạo danh sách sản phẩm
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.handbag1, "The Mirac Jiz","","Lisa Robber","", 195.00F));
        productList.add(new Product(R.drawable.handbag2, "Meriza Kiles","","Gazuna Resika","", 143.45F));
        productList.add(new Product(R.drawable.handbag3, "Loop Hobo", "", "Louis Vuitton", "", 241.00F));
        productList.add(new Product(R.drawable.handbag4, "Croissant MM", "", "Louis Vuitton", "", 265.00F));

        // Tạo và cài đặt Adapter cho RecyclerView
        productAdapter = new ProductAdapter(productList);

        // Thiết lập LayoutManager cho RecyclerView
        rcvProduct.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rcvProduct.setAdapter(productAdapter);

        rcvFavorite.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rcvFavorite.setAdapter(productAdapter); // Sử dụng cùng một adapter cho cả 2 RecyclerView

        return rootView;
    }
}