package com.example.bootcampsatu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText note;
    CheckBox chili, mayo, mustard;
    RadioGroup sizerg;
    Button order;
    ImageView image;
    TextView price;

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

        order.setOnClickListener(this);
    }

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

        int foodImage = image.getImageAlpha();
        float foodPrice = Float.parseFloat(price.getText().toString());

        Food burger = new Food(foodImage, name, noteS, foodPrice, saucestr, sizeS);

        Intent toCheckoutsActivity = new Intent(this, CheckoutActivity.class);
        toCheckoutsActivity.putExtra("food", burger);
        startActivity(toCheckoutsActivity);
        // klo intent mesti implement parcelble di foodnya

        String msg = "You have ordered a " + sizeS + " sized " + name + " with " + saucestr + " sauce" +"\nAddress: \n" +noteS;
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}