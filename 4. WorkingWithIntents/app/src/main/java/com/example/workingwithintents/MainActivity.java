package com.example.workingwithintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText inputNameET;
    private Button wishLuckBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inputNameET = findViewById(R.id.inputNameET);
        wishLuckBtn = findViewById(R.id.wishLuckBtn);

        wishLuckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = inputNameET.getText().toString();
                startWishLuckActivity(inputName);
            }
        });
    }

    private void startWishLuckActivity(String name){
        Intent intent = new Intent(this, WishLuckActivity.class);
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra("EXTRA_MESSAGE", name);
        startActivity(intent);
    }
}