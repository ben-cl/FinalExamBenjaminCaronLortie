package com.example.gsonpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.gsonpractice.Model.Car;
import com.google.gson.Gson;

public class DetailsActivity extends AppCompatActivity {

private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

Car car;

        textView = findViewById(R.id.textView);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Gson gson = new Gson();
            String carAsString = bundle.getString("ContactAsString");
            car = gson.fromJson(carAsString, Car.class);

    textView.setText(car.getName());
//do something
        }

    }
}
