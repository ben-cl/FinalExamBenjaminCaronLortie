package com.example.gsonpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gsonpractice.Model.DictionaryModel;

public class Definition extends AppCompatActivity {

    private TextView defineWordTextView;
    private TextView defineDefinitionTextView;
    private TextView definePosTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definition);


        Intent intent = getIntent();
        final DictionaryModel dictionary = (DictionaryModel)intent.getSerializableExtra("dictionary");

        defineWordTextView = findViewById(R.id.defineWordTextView);
        defineDefinitionTextView = findViewById(R.id.defineDefinitionTextView);
        definePosTextView = findViewById(R.id.definePosTextView);
        // definePosTextView

        defineWordTextView.setText(dictionary.getWord());
        defineDefinitionTextView.setText(dictionary.getDefinition());
        definePosTextView.setText(dictionary.getPos());



        //defineDefinitionTextView
        //defineWordTextView
    }
}
