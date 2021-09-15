package com.example.bootcampsatu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OrderActivity extends AppCompatActivity {

    TextView foodPrice, foodName;
    ImageView foodImage;
    String name;
    float price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        foodPrice = findViewById(R.id.order_price);
        foodName = findViewById(R.id.order_name);
        foodImage = findViewById(R.id.order_image);
//        SharedPreferences sp = getSharedPreferences("sp", MODE_PRIVATE);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("orders");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Food food = snapshot.getValue(Food.class);
                Glide.with(OrderActivity.this).load(food.getFoodImage()).into(foodImage);
                name = food.getFoodName();
                price = food.getFoodPrice();

                foodName.setText(name);
                foodPrice.setText("Rp. " + price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        Glide.with(this).load(sp.getString("image", "")).into(foodImage);

//        SharedPreferences.Editor editor = sp.edit();

//        String name = sp.getString("name", "");
//        float price = sp.getFloat("price", 0);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Resume", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Destroy", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Restart", Toast.LENGTH_SHORT).show();

    }
}