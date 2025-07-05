package com.huynhnha.fashionapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.huynhnha.fashionapp.fagment.HomeFragment;
import com.huynhnha.fashionapp.fagment.SearchFragment;
import com.huynhnha.fashionapp.fagment.SettingFragment;
import com.huynhnha.fashionapp.fagment.ShopFragment;
import com.huynhnha.fashionapp.fagment.WishlistFragment;

public class TabAdapter extends FragmentStateAdapter {
    public TabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new WishlistFragment();
            case 2:
                return new ShopFragment();
            case 3:
                return new SearchFragment();
            case 4:
                return new SettingFragment();
            default:
                return new HomeFragment();
        }

    }
    @Override
    public int getItemCount() {
        return 5;
    }
}
