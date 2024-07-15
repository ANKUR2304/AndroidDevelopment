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

public class CuboidActivity extends AppCompatActivity {
    private EditText inputSide1ET;
    private EditText inputSide2ET;
    private EditText inputSide3ET;
    private Button findVolBtn;
    private TextView volumeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cuboid);

        inputSide1ET = findViewById(R.id.inputSide1ET);
        inputSide2ET = findViewById(R.id.inputSide2ET);
        inputSide3ET = findViewById(R.id.inputSide3ET);

        findVolBtn = findViewById(R.id.findVolBtn);
        volumeTV = findViewById(R.id.volumeTV);

        findVolBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String inputSide1 = inputSide1ET.getText().toString();
                    String inputSide2 = inputSide2ET.getText().toString();
                    String inputSide3 = inputSide3ET.getText().toString();

                    Float side1 = Float.parseFloat(inputSide1);
                    Float side2 = Float.parseFloat(inputSide2);
                    Float side3 = Float.parseFloat(inputSide3);

                    float volume = (float) (side1 * side2 * side3);
                    volumeTV.setText("Volume = " + volume + " unit^3");
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}