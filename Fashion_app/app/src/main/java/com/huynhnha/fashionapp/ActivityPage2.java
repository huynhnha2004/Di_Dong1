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

public class ActivityPage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page2);

        TextView btn_next = findViewById(R.id.btn_next2);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ActivityPage2.this,ActivityPage3.class);
                startActivity(intent);
            }
        });
        TextView btn_next2 = findViewById(R.id.text_skip);
        btn_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ActivityPage2.this,SignInActivity.class);
                startActivity(intent);
            }
        });
        TextView btn_next3 = findViewById(R.id.prev);
        btn_next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ActivityPage2.this,PageActivity1.class);
                startActivity(intent);
            }
        });
    }
}