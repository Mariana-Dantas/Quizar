package com.example.android.quizar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class End_quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_quiz);

        Bundle extras = getIntent().getExtras();
        String score = extras.get("score").toString();
        Log.v("Score: " , score);
        String questions = extras.get("numberQ").toString();
        Log.v("Questions: " , questions);

        TextView txt_points= (TextView) findViewById(R.id.txt_points);
        txt_points.setText(getString(R.string.points, score, questions));
    }


    public void endQuiz(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}