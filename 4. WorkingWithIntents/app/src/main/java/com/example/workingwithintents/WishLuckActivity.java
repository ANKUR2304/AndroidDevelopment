package com.example.workingwithintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class WishLuckActivity extends AppCompatActivity {
    private int luckyNumber;
    private TextView wishTV1;
    private TextView wishTV2;
    private Button shareBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wish_luck);

        wishTV1 = findViewById(R.id.wishTV1);
        wishTV2 = findViewById(R.id.wishTV2);
        shareBtn = findViewById(R.id.shareBtn);

        Intent intent = getIntent();
        String name = intent.getStringExtra("EXTRA_MESSAGE");
        wishLuck(name);

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareMessage(name);
            }
        });
    }

    private void wishLuck(String name){
        String message1 = "Hi " + name + "!";
        luckyNumber = generateRandomNumber();
        String message2 = "your lucky number is " + luckyNumber;
        wishTV1.setText(message1);
        wishTV2.setText(message2);
    }

    private int generateRandomNumber(){
        Random rand = new Random();
        int randNumber = rand.nextInt(100);
        return randNumber;
    }

    private void shareMessage(String name){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT,name + " got lucky today!");
        intent.putExtra(Intent.EXTRA_TEXT, "His lucky number is " + luckyNumber);
        intent.setType("text/plain"); // It is very important to set type while working with Chooser

        Intent chooser = Intent.createChooser(intent, "Share via :");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }
}