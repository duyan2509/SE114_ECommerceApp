package com.example.ECommerceApp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.ECommerceApp.FragmentHomeCategory;
import com.example.ECommerceApp.FragmentHomeHome;
import com.example.ECommerceApp.HomeUser;

public class MyViewPagerAdapter extends FragmentStateAdapter {

    public MyViewPagerAdapter(@NonNull FragmentActivity fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new FragmentHomeHome();
            case 1:
                return new FragmentHomeCategory();
            default:
                return new FragmentHomeHome();
        }
    }
    @Override
    public int getItemCount() {
        return 2;
    }
}
