package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button start_game;
    TextView enter_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseUI();
        start_game.setOnClickListener(view->{
            String username = enter_name.getText().toString();
            FirebaseFirestore users = FirebaseFirestore.getInstance();
            Map<String,Object> users_data = new HashMap<>();
            users_data.put("Name",username);
            // used to handle exception and error
            users.collection("users").document("User "+username).set(users_data).addOnCompleteListener(task ->{
                if(task.isSuccessful()){
                    startActivity(new Intent(MainActivity.this,RulesActivity.class));
                }
            }).addOnFailureListener(Throwable::printStackTrace);
        });
    }

    private void initialiseUI() {
        start_game = findViewById(R.id.start_game);
        enter_name = findViewById(R.id.username);
    }
}