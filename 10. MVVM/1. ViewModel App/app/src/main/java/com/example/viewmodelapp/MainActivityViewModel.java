package com.example.viewmodelapp;

import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private int counter;

    public MainActivityViewModel() {
        this.counter = 0;
    }

    public void increaseCounter(){
        ++counter;
    }

    public int getCounter(){
        return this.counter;
    }
}
