package com.example.android.quizar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open_series_quiz(View view){
        Intent intent = new Intent(this, Quiz_series.class);
        startActivity(intent);
    }

    public void open_character_quiz(View view){
        Intent intent = new Intent(this, Quiz_character.class);
        startActivity(intent);
    }
}