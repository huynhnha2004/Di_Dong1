package com.huynhnha.fashionapp;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

public class OrderSuccessActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);
        android.widget.Button btnBack = findViewById(R.id.btnBackToSearch);
        btnBack.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                // Xóa cart
                android.content.SharedPreferences prefs = getSharedPreferences("cart", MODE_PRIVATE);
                prefs.edit().remove("cart_items").apply();
                finish(); // Quay lại SearchFragment
            }
        });
    }
}
