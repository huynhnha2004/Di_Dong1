package com.huynhnha.fashionapp;

import static androidx.constraintlayout.widget.Constraints.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "https://run.mocky.io/v3/85cf9aaf-aa4f-41bf-b10c-308f032f7ccc";

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
                         tab.setText("Sản phẩm");
                         tab.setIcon(R.drawable.heart_1);
                         break;
                     case 2:
                         tab.setText("Chi tiết");
                         tab.setIcon(R.drawable.shopping);
                         break;
                     case 3:
                         tab.setText("Giỏ hàng");
                         tab.setIcon(R.drawable.search_1);
                         break;
                     case 4:
                         tab.setText("Cài đặt TK");
                         tab.setIcon(R.drawable.settings);
                         break;

                 }
             }
         }).attach();

    }
    private void getData() {
        // RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);

        // String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(getApplicationContext(), "Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "Error :" + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }
}