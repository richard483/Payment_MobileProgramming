package com.example.bootcampsatu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CheckoutActivity extends AppCompatActivity {

    ImageView foodImg;
    TextView foodName, foodAddress, foodPrice, totalPrice;
    Food food;
    Button pay;
//    SharedPreferences sp;
    String imageUrl;

    View.OnClickListener toOrder = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent toOrder = new Intent(CheckoutActivity.this, OrderActivity.class);
            startActivity(toOrder);
        }
    };

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

//        sp = getSharedPreferences("sp", MODE_PRIVATE);

        food = getIntent().getParcelableExtra("food");

        Glide.with(this).load(food.getFoodImage()).into(foodImg);

//        foodImg.setImageAlpha(food.getFoodImage());
        foodName.setText(food.getFoodName());
        foodPrice.setText("Rp. " + food.getFoodPrice());
        foodAddress.setText(food.getFoodAddress());

        float total = 0;
        total += food.getFoodPrice();

        totalPrice.setText("Rp. " + total);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("orders");

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SharedPreferences.Editor editor = sp.edit();
//                editor.putString("image", food.getFoodImage());
//                editor.putString("name", food.getFoodName());
//                editor.putFloat("price", food.getFoodPrice());
//                editor.apply();

                ref.setValue(food);
                Toast.makeText(CheckoutActivity.this, "inserted to DB", Toast.LENGTH_SHORT).show();

//                Toast.makeText(CheckoutActivity.this,"You Pay " + totalPrice.getText(), Toast.LENGTH_SHORT).show();
                Snackbar.make(pay, "You Pay " + totalPrice.getText(), Snackbar.LENGTH_INDEFINITE).
                        setAction("View Order", toOrder).show();


            }
        });
    }

}