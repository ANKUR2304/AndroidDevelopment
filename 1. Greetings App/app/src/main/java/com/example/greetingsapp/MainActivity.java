package com.example.greetingsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameInputET = findViewById(R.id.nameInput);
        Button sayHelloBtn = findViewById(R.id.sayHelloBtn);

        String nameInputString = nameInputET.getText().toString();
        sayHelloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        MainActivity.this,
                        "Welcome " + nameInputString + " to our app!",
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}