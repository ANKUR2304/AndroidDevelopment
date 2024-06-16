package com.example.unitconverterapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView titleTV;
    private EditText kgInputET;
    private Button convertBtn;
    private TextView convertedValueTV;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        titleTV = findViewById(R.id.titleTV);
        kgInputET = findViewById(R.id.kgInputET);
        convertBtn = findViewById(R.id.convertBtn);
        convertedValueTV = findViewById(R.id.convertedValueTV);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertedValueTV.setText(getConvertedValue());
            }
        });

    }

    private String getConvertedValue(){
        try{
            float inputKg = Float.parseFloat(kgInputET.getText().toString());
            float poundValue = (float) (inputKg * 2.20463);
            return inputKg + "Kg = " + poundValue + "pounds";
        } catch (NumberFormatException e) {
            return "Please enter a valid weight value (in Kg).";
        }
    }
}