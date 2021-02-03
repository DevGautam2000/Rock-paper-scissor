package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView leftScore,rightScore , scoreBoard,prompt;

    ImageView p1,p2;
    ImageButton prev,next;
    int index= 0 ;

    boolean run = true;
    Button play,reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //grabbing the id's
        leftScore= findViewById(R.id.leftscore);
        rightScore=findViewById(R.id.rightScore);
        scoreBoard=findViewById(R.id.scoreB);
        p1 = findViewById(R.id.imageView);
        p2 = findViewById(R.id.imageView2);
        play=findViewById(R.id.play);
        reset=findViewById(R.id.reset);

        prev=findViewById(R.id.prev);
        next= findViewById(R.id.next);
        prompt= findViewById(R.id.prompt);



        int[] display = new int[]{R.drawable.rock,
                R.drawable.paper,
                R.drawable.scissor};


        if (!run){

            reset();
        }



        String[] prom = new String[]{"Rock","Paper","Scissor"};

        MainActivity ref = new MainActivity();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(index<0)
                    index=2;

                if(index>2)
                    index=0;

                prompt.setText(prom[index--]);
            }

        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(index>2)
                    index=0;

                if(index<0)
                    index=2;

                prompt.setText(prom[index++]);
            }
        });


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int count1=0, count2=0;



                    Random rand = new Random();
                    int numP1= rand.nextInt(3);
                    String P1;
                    String P2 = prompt.getText().toString().trim();



                    if(numP1==0)
                        P1=prom[numP1];

                    else if(numP1==1)
                        P1=prom[numP1];

                    else
                        P1=prom[numP1];





                    if(P2.equalsIgnoreCase("rock")) {
                        p2.setVisibility(View.VISIBLE);
                        p2.setImageResource(display[0]);
                    }

                    else if(P2.equalsIgnoreCase("paper"))
                    {
                        p2.setVisibility(View.VISIBLE);
                        p2.setImageResource(display[1]);
                    }

                    else if (P2.equalsIgnoreCase("scissor"))
                    {
                        p2.setVisibility(View.VISIBLE);
                        p2.setImageResource(display[2]);
                    }

                    else
                        return;

                p1.setVisibility(View.VISIBLE);
                p1.setImageResource(display[numP1]);





                    if(P2.equalsIgnoreCase("Rock") && P1.equalsIgnoreCase("paper") ||
                            P2.equalsIgnoreCase("scissor") && P1.equalsIgnoreCase("rock") ||
                            P2.equalsIgnoreCase("paper") && P1.equalsIgnoreCase("scissor"))
                        count1++;

                    else if(P2.equalsIgnoreCase("paper") && P1.equalsIgnoreCase("rock") ||
                            P2.equalsIgnoreCase("Rock") && P1.equalsIgnoreCase("scissor") ||
                            P2.equalsIgnoreCase("scissor") && P1.equalsIgnoreCase("paper"))
                        count2++;


//                updating scores
                    leftScore.setText(Integer.toString(count1));
                    rightScore.setText(Integer.toString(count2));


                if(count1>count2)
                {
                    scoreBoard.setText("Computer Wins!");
                    leftScore.setText(String.format("P1: %d Pt", count1));
                    rightScore.setText(String.format("P2: %d Pt", count2));
                }

                    //if count2 is greater user wins
                else if(count1<count2)
                {
                    scoreBoard.setText("You Win!");
                    leftScore.setText(String.format("P1: %d Pt", count1));
                    rightScore.setText(String.format("P2: %d Pt", count2));
                }

                    //else a tie!
                else
                {
                    scoreBoard.setText("Its a tie!");
                    leftScore.setText(String.format("P1: %d Pt", count1));
                    rightScore.setText(String.format("P2: %d Pt", count2));
                }





            }
        });


        run=false;

    }

    private void reset() {

        scoreBoard.setText("Score Board");
        p1.setVisibility(View.INVISIBLE);
        p2.setVisibility(View.INVISIBLE);
        prompt.setText("Choose Object");


    }
}