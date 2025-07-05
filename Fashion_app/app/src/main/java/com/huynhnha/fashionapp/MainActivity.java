package com.huynhnha.fashionapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tablayout);
        ViewPager2 pager2 = findViewById(R.id.viewpager2);

        TabAdapter tabAdapter = new TabAdapter(this);
        pager2.setAdapter(tabAdapter);
         new TabLayoutMediator(tabLayout, pager2, new TabLayoutMediator.TabConfigurationStrategy() {
             @Override
             public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                 switch(position){
                     case 0:
                         tab.setText("Home");
                         tab.setIcon(R.drawable.home_1);
                         break;
                     case 1:
                         tab.setText("Wishlist");
                         tab.setIcon(R.drawable.heart_1);
                         break;
                     case 2:
                         tab.setText("Shop");
                         tab.setIcon(R.drawable.shopping);
                         break;
                     case 3:
                         tab.setText("Search");
                         tab.setIcon(R.drawable.search_1);
                         break;
                     case 4:
                         tab.setText("Setting");
                         tab.setIcon(R.drawable.settings);
                         break;

                 }
             }
         }).attach();

    }
}