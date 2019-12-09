package com.example.gsonpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gsonpractice.Model.DictionaryModel;

public class French extends AppCompatActivity {


    private TextView englishTextView;
    private TextView frenchTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french);


        Intent intent = getIntent();
        final DictionaryModel dictionary = (DictionaryModel)intent.getSerializableExtra("dictionary");

        englishTextView = findViewById(R.id.englishTextView);
        frenchTextView = findViewById(R.id.frenchTextView);


        englishTextView.setText(dictionary.getWord());
        frenchTextView.setText(dictionary.getFrench());



        // frenchTextView
        // englishTextView
    }
}
