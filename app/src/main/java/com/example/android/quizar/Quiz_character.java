package com.example.android.quizar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz_character extends AppCompatActivity {

    public int score=0;
    public  int numberQ=0;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        onWindowFocusChanged(true);
        TextView question = (TextView) findViewById(R.id.txt_question);
        question.setText(getString(R.string.character_question));
        ImageView img = (ImageView) findViewById(R.id.img_series);
        img.setImageResource(R.drawable.series);

        listQuestions();

    }

    // List of Questions

    public void listQuestions(){
        if (numberQ==0){
            question(R.drawable.char_tyrionlannister,
                    "Sandor Clegane",
                    "Jon Snow",
                    "Jaime Lannister",
                    "Tyrion Lannister",
                    4);
        }
        if (numberQ==1){
            question(R.drawable.char_jesse,
                    "Mike Ehrmantraut",
                    "Jesse Pinkman",
                    "Walter White",
                    "Saul Goodman",
                    2);
        }
        if (numberQ==2){
            question(R.drawable.char__eleven,
                    "Eleven",
                    "Nancy wheeler",
                    "Robin",
                    "Twelve",
                    1);
        }
        if (numberQ==3){
            question(R.drawable.char_thomas,
                    "Arthus Shelby",
                    "John Shelby",
                    "Thomas Shelby",
                    "Michael Gray",
                    3);
        }
        if (numberQ==4){
            question(R.drawable.char_alex,
                    "Piper Chapman",
                    "Zulema",
                    "Alex Vouse",
                    "Macarena",
                    3);
        }
        if (numberQ==5){
            question(R.drawable.char_rick,
                    "Rick Grimes",
                    "Daryl Reedus",
                    "Negan",
                    "Glenn Rhee",
                    1);
        }
        if (numberQ==6){
            question(R.drawable.char_zulema,
                    "Alicia Sierra",
                    "Zulema",
                    "Nairobi",
                    "Saray Vargas",
                    2);
        }
        if (numberQ==7){
            question(R.drawable.char_hanna,
                    "Jessica Davis",
                    "Olivia Baker",
                    "Sheri Holliand",
                    "Hanna Baker",
                    4);
        }
        if (numberQ==8){
            question(R.drawable.char_jughead,
                    "Bryce Walker",
                    "Archie Andrews",
                    "Clay Jensen",
                    "Jughead Jones",
                    4);

        }
        if (numberQ==9){
            question(R.drawable.char_sherlock_holmes,
                    "Sherlock Holmes",
                    "Dr. John Watson",
                    "Inspector Lestrade",
                    "Inspector Gadget",
                    1);
        }
        if (numberQ==10){
            Intent intent = new Intent(this, End_quiz.class);
            intent.putExtra("score", score);
            intent.putExtra("numberQ", numberQ);
            startActivity(intent);
        }
    }


    // Question
    // args: Image of the question
    //      Awnser 1, Awnser 2, Awnser 3, Awnser 4
    //      Number of the right awnser
    public void question(int imagem, String awnser1, String awnser2, String awnser3, String awnser4, int rightawnser){
        ImageView img = (ImageView) findViewById(R.id.img_series);
        img.setImageResource(imagem);

        Button option1 = (Button) findViewById(R.id.btn_opt1);
        Button option2 = (Button) findViewById(R.id.btn_opt2);
        Button option3 = (Button) findViewById(R.id.btn_opt3);
        Button option4 = (Button) findViewById(R.id.btn_opt4);

        option1.setText(awnser1);
        option2.setText(awnser2);
        option3.setText(awnser3);
        option4.setText(awnser4);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                certoErrado(1,rightawnser);
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                certoErrado(2,rightawnser);
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                certoErrado(3,rightawnser);
            }

        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                certoErrado(4,rightawnser);
            }
        });
    }

    // Right or wrong
    // if its the right awnser adds 1 to the score and increments the questions
    // if its wrong it only increments the number of the question
    public void certoErrado(int right, int rightawnser){
        if(rightawnser==right){

            score+=1;
            numberQ+=1;
            listQuestions();
        }else{

            numberQ+=1;
            listQuestions();
        }
    }

    // Next Question
    public void perguntaSeguinte(View view){
        numberQ+=1;
        listQuestions();
    }
    // Previous Question
    public void perguntaAnterior(View view){

        numberQ-=1;
        if(numberQ < 0){
            Context context = getApplicationContext();
            CharSequence text = getString(R.string.noquestionsless);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            numberQ=0;
        }
        listQuestions();
    }
    // End Quiz
    public void endQuiz(View view) {
        Intent intent = new Intent(this, End_quiz.class);
        intent.putExtra("score", score);
        intent.putExtra("numberQ", numberQ);
        startActivity(intent);
    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }



}