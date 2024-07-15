package com.example.volumecalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView titleTV;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        titleTV = findViewById(R.id.titleTV);

        // GridView
        gridView = findViewById(R.id.gridView);

        // Data
        ArrayList<String> data = new ArrayList<>();
        data.add("Sphere");
        data.add("Cube");
        data.add("Cylinder");
        data.add("Cuboid");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.sphere);
        images.add(R.drawable.cube);
        images.add(R.drawable.cylinder);
        images.add(R.drawable.cuboid);

        // Adapter
        GridAdapter gridAdapter = new GridAdapter(this, data, images);
        // Set Adapter
        gridView.setAdapter(gridAdapter);

        // Set Item click-listener
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        onSphereClicked();
                        break;

                    case 1:
                        onCubeClicked();
                        break;

                    case 2:
                        onCylinderClicked();
                        break;

                    case 3:
                        onCuboidClicked();
                        break;
                }
            }
        });
    }

    private void onSphereClicked(){
        Intent intent = new Intent(this, SphereActivity.class);
        startActivity(intent);
    }

    private void onCubeClicked(){
        Intent intent = new Intent(this, CubeActivity.class);
        startActivity(intent);
    }

    private void onCylinderClicked(){
        Intent intent = new Intent(this, CylinderActivity.class);
        startActivity(intent);
    }

    private void onCuboidClicked(){
        Intent intent = new Intent(this, CuboidActivity.class);
        startActivity(intent);
    }
}