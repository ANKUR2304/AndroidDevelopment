package com.example.volumecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CubeActivity extends AppCompatActivity {
    private EditText inputSideET;
    private Button findVolBtn;
    private TextView volumeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cube);

        inputSideET = findViewById(R.id.inputSideET);
        findVolBtn = findViewById(R.id.findVolBtn);
        volumeTV = findViewById(R.id.volumeTV);

        findVolBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String input = inputSideET.getText().toString();
                    float side = Float.parseFloat(input);
                    float volume = (float) (side * side * side);
                    volumeTV.setText("Volume = " + volume + " unit^3");
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}