package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class YourOrder extends AppCompatActivity {
    TextView tvTotalPrice2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_order);
        tvTotalPrice2 = findViewById(R.id.tvTotalPrice2);
        Intent intent = getIntent();
        int totalPrice = intent.getIntExtra("totalPrice", 1);
        tvTotalPrice2.setText(totalPrice + "$");
    }
}
