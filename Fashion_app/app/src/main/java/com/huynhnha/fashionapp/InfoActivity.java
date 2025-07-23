package com.huynhnha.fashionapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        String info = intent.getStringExtra("user_info");
        TextView infoText = findViewById(R.id.txtInfo);
        infoText.setText(info);

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }
}
