package com.example.bootcampsatu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity {

    ImageView foodImg;
    TextView foodName, foodAddress, foodPrice, totalPrice;
    Food food;
    Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        foodImg = findViewById(R.id.checkout_food_img);
        foodName = findViewById(R.id.checkout_food_name);
        foodAddress = findViewById(R.id.checkout_food_address);
        foodPrice = findViewById(R.id.checkout_food_price);
        totalPrice = findViewById(R.id.total_price);
        pay = findViewById(R.id.checkout_pay_button);

        food = getIntent().getParcelableExtra("food");

        foodImg.setImageAlpha(food.getFoodImage());
        foodName.setText(food.getFoodName());
        foodPrice.setText("Rp. " + food.getFoodPrice());
        foodAddress.setText(food.getFoodAddress());

        float total = 0;
        total += food.getFoodPrice();

        totalPrice.setText("Rp. " + total);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CheckoutActivity.this,"You Pay " + totalPrice.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}