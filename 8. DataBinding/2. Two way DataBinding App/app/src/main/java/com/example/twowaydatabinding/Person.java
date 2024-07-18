package com.example.twowaydatabinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class Person extends BaseObservable {

    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // This anotation is also important for two-way data-binding
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name); // this notification is crucial for two-way data-binding, and this method is provided by BaseObservable
    }

    // This anotation is also important for two-way data-binding
    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email); // this notification is crucial for two-way data-binding, and this method is provided by BaseObservable
    }
}
