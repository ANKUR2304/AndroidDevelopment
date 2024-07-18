package com.example.viewmodelandlivedataapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private final MutableLiveData<Integer> count;

      public MainActivityViewModel(){
          count = new MutableLiveData<>();
//        count.setValue(0);
      }

    public void increaseCount(){
        int currVal = count.getValue() == null ? 0 : count.getValue(); // This check is very important while working with viewModel;
        // because liveData.getValue() can return null in somecases, so, to avoid null-pointer exception, this check is important
        // or you can set value of count first (in constructor) to make sure that getValue() doesn't return null.
        //int currVal = count.getValue();
        count.setValue(currVal + 1);
    }

    public MutableLiveData<Integer> getCount(){
        return count;
    }
}
