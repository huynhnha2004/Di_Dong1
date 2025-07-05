package com.huynhnha.fashionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityPage3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page3);

        TextView btn_next = findViewById(R.id.getstarted);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ActivityPage3.this,SignInActivity.class);
                startActivity(intent);
            }
        });
        TextView btn_next2 = findViewById(R.id.text_skip);
        btn_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ActivityPage3.this,SignInActivity.class);
                startActivity(intent);
            }
        });
        TextView btn_next3 = findViewById(R.id.prev);
        btn_next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ActivityPage3.this,ActivityPage2.class);
                startActivity(intent);
            }
        });
    }
}