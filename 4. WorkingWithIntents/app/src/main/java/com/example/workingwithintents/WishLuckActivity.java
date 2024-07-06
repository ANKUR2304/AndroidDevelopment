package com.example.workingwithintents;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class WishLuckActivity extends AppCompatActivity {
    private TextView wishTV1;
    private TextView wishTV2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wish_luck);

        wishTV1 = findViewById(R.id.wishTV1);
        wishTV2 = findViewById(R.id.wishTV2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("EXTRA_MESSAGE");
        wishLuck(name);
    }

    private void wishLuck(String name){
        String message1 = "Hi " + name + "!";
        String message2 = "your lucky number is " + generateRandomNumber();
        wishTV1.setText(message1);
        wishTV2.setText(message2);
    }

    private int generateRandomNumber(){
        Random rand = new Random();
        int randNumber = rand.nextInt(100);
        return randNumber;
    }
}