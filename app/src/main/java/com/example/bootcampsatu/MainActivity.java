package com.example.bootcampsatu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText note;
    CheckBox chili, mayo, mustard;
    RadioGroup sizerg;
    Button order;
    ImageView image;
    TextView price;
    ImageView call;
    String imageUrl = "data:image/jpeg;base64,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";


    View.OnClickListener callRestaurant = view -> {
        String phoneNumber = "08128661286";
        Intent callPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
        startActivity(callPhone);

    };

//    View.OnClickListener callRestaurant = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            String phoneNumber = "*123# ";
//            Intent callPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
//            startActivity(callPhone);
//
//        }
//    }; ini klo ga di replace pake lambda kek d atas


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        note = findViewById(R.id.address_et);
        chili = findViewById(R.id.chilli_sauce);
        mayo = findViewById(R.id.mayo_sauce);
        mustard = findViewById(R.id.must_sauce);
        sizerg = findViewById(R.id.size_rg);
        order = findViewById(R.id.order_bt);
        image = findViewById(R.id.food_img);
        price = findViewById(R.id.food_price);
        call = findViewById(R.id.call_button);

        //Glide Lib
        Glide.with(this).load(imageUrl).into(image);


        ArrayList<String>sizes = new ArrayList<>();
        sizes.add("small");
        sizes.add("medium");
        sizes.add("large");
        sizes.add("XL");

        for(int i=0; i< sizes.size(); i++){
            RadioButton s = new RadioButton(this);
            s.setText(sizes.get(i));
            s.setId(i);
            sizerg.addView(s);
        }

        order.setOnClickListener(new ButtonOnClick());
        call.setOnClickListener(callRestaurant);
    }

    class ButtonOnClick implements View.OnClickListener{//cara ini sama aj sama yg this, cuman ini klo d pake d class lain

        @Override
        public void onClick(View view) {
            String name = getString(R.string.burger);
            String saucestr = "";
            if(chili.isChecked()) saucestr+= "Chilli sauce";
            if(mayo.isChecked()) saucestr+= " Mayo ";
            if(mustard.isChecked()) saucestr += " Mustard ";

            int id = sizerg.getCheckedRadioButtonId();
            RadioButton selected = findViewById(id);
            String sizeS = selected.getText().toString();


            String noteS = note.getText().toString();

            String foodImage = imageUrl;
            float foodPrice = Float.parseFloat(price.getText().toString());

            Food burger = new Food(foodImage, name, noteS, foodPrice, saucestr, sizeS);

            String msg = "You have ordered a " + sizeS + " sized " + name + " with " + saucestr + " sauce" +"\nAddress: \n" +noteS;
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

            Intent toCheckoutsActivity = new Intent(MainActivity.this, CheckoutActivity.class);
            toCheckoutsActivity.putExtra("food", burger);
            startActivity(toCheckoutsActivity);
            // klo intent mesti implement parcelble di foodnya
        }
    }

    @Override
    public void onClick(View view) {

    }
}