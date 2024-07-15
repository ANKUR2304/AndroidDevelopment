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

public class CylinderActivity extends AppCompatActivity {
    private EditText inputHeightET;
    private EditText inputRadiusET;
    private Button findVolBtn;
    private TextView volumeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);

        inputHeightET = findViewById(R.id.inputHeightET);
        inputRadiusET = findViewById(R.id.inputRadiusET);
        findVolBtn = findViewById(R.id.findVolBtn);
        volumeTV = findViewById(R.id.volumeTV);

        findVolBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String inputRadius = inputRadiusET.getText().toString();
                    String inputHeight = inputHeightET.getText().toString();
                    float radius = Float.parseFloat(inputRadius);
                    float height = Float.parseFloat(inputHeight);
                    float volume = (float) (3.14159 * radius * radius * height);
                    volumeTV.setText("Volume = " + volume + " unit^3");
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}