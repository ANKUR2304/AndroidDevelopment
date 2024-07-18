package com.example.twowaydatabinding;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.twowaydatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    Person person1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        );

        person1 = new Person("Ankur", "ankurjakhar98@gmail.com");
        activityMainBinding.setPerson(person1);
    }
}