package com.example.viewmodelapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private TextView counterTV;
    private Button incraseCountBtn;

    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Can't use simple Data-Binding with primitive data-types
        // Because multiple inheritance is not allowed in Java
        // Although we can use Observable fields or LiveData with ViewModel (for Data-Binding)
        counterTV = findViewById(R.id.counterTV);
        incraseCountBtn = findViewById(R.id.increaseCountBtn);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        counterTV.setText("" + mainActivityViewModel.getCounter());

        incraseCountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.increaseCounter();
                counterTV.setText("" + mainActivityViewModel.getCounter());
            }
        });
    }
}