package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FoodAdapter foodAdapter;
    ArrayList<Food> foodList;
    ArrayList<Food> orderFoodList;
    int totalCount = 0;
    int food1Count =0, food2Count =0, food3Count =0, food4Count =0, food5Count =0, food6Count =0;
    int totalPrice;
    Food food1, food2, food3, food4, food5, food6;
    TextView tvQuantity, tvTotalPrice;
    TextView tvSendOrder;
    Button btnOrder;
    FrameLayout frCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        food1 = new Food(getResources().getString(R.string.food1));
        food2 = new Food(getResources().getString(R.string.food2));
        food3 = new Food(getResources().getString(R.string.food3));
        food4 = new Food(getResources().getString(R.string.food4));
        food5 = new Food(getResources().getString(R.string.food5));
        food6 = new Food(getResources().getString(R.string.food6));

        foodList = new ArrayList<>();
        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);
        foodList.add(food4);
        foodList.add(food5);
        foodList.add(food6);

        foodAdapter = new FoodAdapter(foodList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(foodAdapter);

        foodAdapter.setIonClick(new IonClick() {
            @Override
            public void onClick(String name) {
                totalCount++;
                totalPrice = totalCount*10;
                tvQuantity.setText(String.valueOf(totalCount));
                tvTotalPrice.setText(totalPrice+"$");
                if (name.equals(food1.getName())){
                    food1Count++;
                }
                if (name.equals(food2.getName())){
                    food2Count++;
                }
                if (name.equals(food3.getName())){
                    food3Count++;
                }
                if (name.equals(food4.getName())){
                    food4Count++;
                }
                if (name.equals(food5.getName())){
                    food5Count++;
                }
                if (name.equals(food6.getName())){
                    food6Count++;
                }
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSendOrder.setText("Thank you! Your order is sent to restaurant!");
            }
        });

        frCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), YourOrder.class);
                intent.putExtra("totalPrice", totalPrice);
                orderFoodList = new ArrayList<>();
                if (food1Count>0){
                    Food orderFood1 = new Food(food1.getName(), food1Count);
                    orderFoodList.add(orderFood1);
                }
                if (food2Count>0){
                    Food orderFood2 = new Food(food2.getName(), food2Count);
                    orderFoodList.add(orderFood2);
                }
                if (food3Count>0){
                    Food orderFood3 = new Food(food3.getName(), food3Count);
                    orderFoodList.add(orderFood3);
                }
                if (food4Count>0){
                    Food orderFood4 = new Food(food4.getName(), food4Count);
                    orderFoodList.add(orderFood4);
                }
                if (food5Count>0){
                    Food orderFood5 = new Food(food5.getName(), food5Count);
                    orderFoodList.add(orderFood5);
                }
                if (food6Count>0){
                    Food orderFood6 = new Food(food6.getName(), food6Count);
                    orderFoodList.add(orderFood6);
                }
                startActivity(intent);
            }
        });
    }
    public void initView(){
        recyclerView = findViewById(R.id.rvList);
        tvQuantity = findViewById(R.id.tvQuantity);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        btnOrder = findViewById(R.id.btnOrder);
        tvSendOrder = findViewById(R.id.tvSendOrder);
        frCart = findViewById(R.id.cart);
    }
}
