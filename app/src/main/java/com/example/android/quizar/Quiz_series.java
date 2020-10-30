package com.example.android.quizar;

import android.annotation.SuppressLint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz_series extends AppCompatActivity {

    public int score=0;
    public  int numberQ=0;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        onWindowFocusChanged(true);
        TextView question = (TextView) findViewById(R.id.txt_question);
        question.setText(getString(R.string.series_question));
        ImageView img = (ImageView) findViewById(R.id.img_series);
        img.setImageResource(R.drawable.series);

        listQuestions();

    }

    // List of Questions

    public void listQuestions(){
        if (numberQ==0){
            question(R.drawable.serie_taboo,
                    "Peaky Blinders",
                    "Taboo",
                    "Game of Thrones",
                    "The Take",
                    2);
        }
        if (numberQ==1){
            Log.v("Olá", "pergunta 2");
            question(R.drawable.serie_riverdale,
                    "Altered Carbon",
                    "13 Reasons Why",
                    "Riverdale",
                    "Mandalorian",
                    3);
        }
        if (numberQ==2){
            question(R.drawable.serie_blackmirror,
                    "Westworld",
                    "Narcos",
                    "Blackmirror",
                    "Supernatural",
                    3);
        }
        if (numberQ==3){
            question(R.drawable.serie_thewitcher,
                    "The Witcher",
                    "Dexter",
                    "Taboo",
                    "American Horror Story",
                    1);
        }
        if (numberQ==4){
            question(R.drawable.serie_walkingdead,
                    "Westworld",
                    "Homeland",
                    "Blindspot",
                    "The Walking Dead",
                    4);
        }
        if (numberQ==5){
            question(R.drawable.serie_westworld,
                    "Westworld",
                    "Glee",
                    "Blackmirror",
                    "Lost",
                    1);
        }
        if (numberQ==6){
            question(R.drawable.serie_you,
                    "Dirty John",
                    "You",
                    "Zark",
                    "The 100",
                    2);
        }
        if (numberQ==7){
            question(R.drawable.serie_breakingbad,
                    "Breaking Bad",
                    "Narcos",
                    "Scream",
                    "Prison Break",
                    1);
        }
        if (numberQ==8){
            question(R.drawable.serie_theboys,
                    "Lucifer",
                    "Friends",
                    "The Boys",
                    "Elite",
                    3);

        }
        if (numberQ==9){
            question(R.drawable.serie_strangerthings,
                    "Orange is the new Black",
                    "Riverdale",
                    "Stranger Things",
                    "Friends",
                    3);
        }
        if (numberQ==10){
            question(R.drawable.serie_chernobyl,
                    "Amerrican Horror Story",
                    "The Handmaid's Tale",
                    "Zone of Exclusion",
                    "Chernobyl",
                    4);
        }
        if (numberQ==11){
            question(R.drawable.serie_moneyheist,
                    "Money Heist",
                    "The Queen Gambit",
                    "Barbarians",
                    "The Office",
                    1);
        }
        if (numberQ==12){
            question(R.drawable.serie_sherlock_holmes,
                    "Supernatural",
                    "Sherlock Holmes",
                    "Doctor Who",
                    "Sherlock",
                    4);
        }
        if (numberQ==13){
            question(R.drawable.serie_umbrelaacademy,
                    "Stranger Things",
                    "Riverdale",
                    "The Umbrela Academy",
                    "13 Reasons Why",
                    3);
        }
        if (numberQ==14){
            question(R.drawable.serie_mandalorian,
                    "The Mandalorian",
                    "Star Wars",
                    "The Punisher",
                    "Taboo",
                    1);
        }
        if (numberQ==15){
            question(R.drawable.serie_elite,
                    "Elite",
                    "Money Heist",
                    "Vis a Vis",
                    "Red is the new Black",
                    1);
        }
        if (numberQ==16){
            question(R.drawable.serie_euphoria,
                    "How to Sell Drugs Online (Fast)",
                    "Euphoria",
                    "Revenge",
                    "After We Collided",
                    2);
        }
        if (numberQ==17){
            question(R.drawable.serie_dirtyjohn,
                    "Rebecca",
                    "Holidate",
                    "You",
                    "Dirty John",
                    4);
        }
        if (numberQ==18){
            question(R.drawable.serie_peakyblinders,
                    "Peaky Blinders",
                    "Taboo",
                    "Vikings",
                    "Boardwalk Empire",
                    1);
        }
        if (numberQ==19){
            question(R.drawable.serie_twtwo,
                    "Dexter",
                    "11.22.63",
                    "Humans",
                    "Mr Robot",
                    2);
        }
        if (numberQ==20){
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