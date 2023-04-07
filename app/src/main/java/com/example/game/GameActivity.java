package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class GameActivity extends AppCompatActivity {
    Button b_rock, b_paper, b_scissor;
    int robotScore;
    TextView player_score,robot_score;
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
        ImageView playerChoice = (ImageView) findViewById(R.id.playerChoice);
        robotchoice = (ImageView) findViewById(R.id.robotChoice);
        b_rock.setOnClickListener(view -> {
            playerChoice.setImageResource(R.drawable.rock);
            play_turn("rock");
        });
        b_paper.setOnClickListener(view -> {
            playerChoice.setImageResource(R.drawable.paper_1);
            play_turn("paper");
        });
        b_scissor.setOnClickListener(view -> {
            playerChoice.setImageResource(R.drawable.scissor_1);
            play_turn("scissor");
        });
    }

    public String play_turn(String player_choice) {
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
        } else if (Robot_choice.equals("paper")) {
            robotchoice.setImageResource(R.drawable.paper_1);
        } else if (Robot_choice.equals("scissor")) {
            robotchoice.setImageResource(R.drawable.scissor_1);
        }
        //robot human and robot choice to determine who won
        if (Robot_choice.equals(player_choice)) {
            msg = "Draw nobody won";
        } else if (player_choice.equals("rock") && Robot_choice.equals("scissor") && player_choice.equals("paper") && Robot_choice.equals("rock") && player_choice.equals("scissors") && Robot_choice.equals("paper")) {
            playerscore++;
            player_score.setText(playerscore);
            msg = "Rock crushes scissors. You win";
        }
        return msg;
    }
}