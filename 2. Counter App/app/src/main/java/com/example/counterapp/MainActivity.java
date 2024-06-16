package com.example.counterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView titleTV;
    private TextView counterTV;
    private Button clickMeBtn;

    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        titleTV = findViewById(R.id.titleTV);
        counterTV = findViewById(R.id.counterTV);
        clickMeBtn = findViewById(R.id.clickMeBtn);

        clickMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterTV.setText("" + incrementCounter());
            }
        });
    }

    private int incrementCounter(){
        ++count;
        return count;
    }
}