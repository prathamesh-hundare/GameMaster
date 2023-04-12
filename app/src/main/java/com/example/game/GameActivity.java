package com.example.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class GameActivity extends AppCompatActivity {
    Button b_rock, b_paper, b_scissor;
    int robotScore;
    TextView player_score,robot_score,lifeline;

    int score=0;
    int life=3;
    TextView TotalScore;

    Imageview humanchoice;
    ImageView robotchoice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //findViewById(R.id.container).setBackground(R.drawable.launching_page);
        setContentView(R.layout.activity_game);
        b_rock = (Button) findViewById(R.id.b_rock);
        player_score = (TextView) findViewById(R.id.player_score);
        robot_score = (TextView) findViewById(R.id.robot_score);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissor = (Button) findViewById(R.id.b_scissor);
        TotalScore = (TextView) findViewById(R.id.TotalScore);
        lifeline =(TextView) findViewById(R.id.lifeline);
        lifeline.setText(String.valueOf(life));

        ImageView playerChoice = (ImageView) findViewById(R.id.playerChoice);
        robotchoice = (ImageView) findViewById(R.id.robotChoice);
        b_rock.setOnClickListener(view -> {
            playerChoice.setImageResource(R.drawable.rock);

            Animation animation=AnimationUtils.loadAnimation(GameActivity.this,R.anim.shake_anim);
            playerChoice.startAnimation(animation);


            play_turn("rock");
        });
        b_paper.setOnClickListener(view -> {
            playerChoice.setImageResource(R.drawable.paper_1);

            Animation animation=AnimationUtils.loadAnimation(GameActivity.this,R.anim.shake_anim);
            playerChoice.startAnimation(animation);

            play_turn("paper");
        });
        b_scissor.setOnClickListener(view -> {
            playerChoice.setImageResource(R.drawable.scissor_1);

            Animation animation=AnimationUtils.loadAnimation(GameActivity.this,R.anim.shake_anim);
            playerChoice.startAnimation(animation);

            play_turn("scissor");
        });
    }

    public void play_turn(String player_choice) {
        int playerscore = 0;
        String msg = "";
        String Robot_choice = null;
        Random r = new Random();
        //choose 1 2 3
        int robot_choice_number = r.nextInt(3) + 1;
        if (robot_choice_number == 1) {
            Robot_choice = "rock";
        } else if (robot_choice_number == 2) {
            Robot_choice = "paper";
        } else if (robot_choice_number == 3) {
            Robot_choice = "scissor";
        }
        //set the computer image based on his choice
        if (Robot_choice.equals("rock")) {
            robotchoice.setImageResource(R.drawable.rock);
            Animation animation=AnimationUtils.loadAnimation(GameActivity.this,R.anim.shake_anim);
            robotchoice.startAnimation(animation);
        } else if (Robot_choice.equals("paper")) {
            robotchoice.setImageResource(R.drawable.paper_1);
            Animation animation=AnimationUtils.loadAnimation(GameActivity.this,R.anim.shake_anim);
            robotchoice.startAnimation(animation);
        } else if (Robot_choice.equals("scissor")) {
            robotchoice.setImageResource(R.drawable.scissor_1);
            Animation animation=AnimationUtils.loadAnimation(GameActivity.this,R.anim.shake_anim);
            robotchoice.startAnimation(animation);
        }
        //robot human and robot choice to determine who won
        if (Robot_choice.equals(player_choice)) {
            msg = "Draw nobody won";


            AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
            builder.setTitle("Status");
            builder.setMessage(msg);
            builder.setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog alertDialog= builder.create();
            alertDialog.show();


        }
        if(player_choice.equals("rock")&&Robot_choice.equals("scissor")){
            msg = "Rock Crushes Scissor, You Win";
            score+=1;
            TotalScore.setText(String.valueOf(score));

            AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
            builder.setTitle("Status");
            builder.setMessage(msg);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog alertDialog= builder.create();
            alertDialog.show();
        }
        if(player_choice.equals("rock")&&Robot_choice.equals("paper")){
            msg = "Paper Cuts Scissor, You Lost";
            life-=1;
            lifeline.setText(String.valueOf(life));

            if(life==0){
                AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                builder.setTitle("Game Finised");
                builder.setMessage("You have ran out of your lives");
                builder.setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(GameActivity.this,GameActivity.class));
                        finish();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
            builder.setTitle("Status");
            builder.setMessage(msg);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AlertDialog alertDialog= builder.create();
            alertDialog.show();
        }
        if(player_choice.equals("paper")&&Robot_choice.equals("rock")){
            msg = "Paper Cuts Rock, You Win";
            score+=1;
            TotalScore.setText(String.valueOf(score));

            AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
            builder.setTitle("Status");
            builder.setMessage(msg);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AlertDialog alertDialog= builder.create();
            alertDialog.show();
        }
        if(player_choice.equals("paper")&&Robot_choice.equals("scissor")){
            msg = "Scissor Cuts paper, You Lost";

            life-=1;
            lifeline.setText(String.valueOf(life));

            if(life==0){
                AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                builder.setTitle("Game Finised");
                builder.setMessage("You have ran out of your lives");
                builder.setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(GameActivity.this,GameActivity.class));
                        finish();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }


            AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
            builder.setTitle("Status");
            builder.setMessage(msg);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AlertDialog alertDialog= builder.create();
            alertDialog.show();
        }
        if(player_choice.equals("scissor")&&Robot_choice.equals("paper")){
            msg = "Scissor Cuts paper, You Win";
            score+=1;
            TotalScore.setText(String.valueOf(score));

            AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
            builder.setTitle("Status");
            builder.setMessage(msg);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog alertDialog= builder.create();
            alertDialog.show();
        }
        if(player_choice.equals("scissor")&&Robot_choice.equals("rock")){
            msg = "Rock Crushes scissor, You Lost";

            life-=1;
            lifeline.setText(String.valueOf(life));

            if(life==0){
                AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                builder.setTitle("Game Finised");
                builder.setMessage("You have ran out of your lives");
                builder.setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(GameActivity.this,GameActivity.class));
                        finish();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }


            AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
            builder.setTitle("Status");
            builder.setMessage(msg);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog alertDialog= builder.create();
            alertDialog.show();
        }


    }
}