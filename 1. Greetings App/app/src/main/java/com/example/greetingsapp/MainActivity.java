package com.example.greetingsapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button sayHelloBtn;
    private EditText nameInputET;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nameInputET = findViewById(R.id.inputNameET);
        sayHelloBtn = findViewById(R.id.sayHelloBtn);
        sayHelloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = nameInputET.getText().toString();
                String toastMessage = "Welcome " + inputName + " to our app!";
                Toast.makeText(
                        MainActivity.this,
                        toastMessage,
                        Toast.LENGTH_LONG
                        ).show();
            }
        });
    }
}