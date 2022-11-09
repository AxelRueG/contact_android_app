package com.example.mycontacts.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mycontacts.views.FormContact;

public class FormViewModel extends ViewModel {
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> number = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<Boolean> favorite = new MutableLiveData<>();
    public Operations operation = Operations.CREATE;
    public MutableLiveData<Boolean> operationResult = new MutableLiveData<>();

    public void handleButton(){
        switch (operation) {
            case CREATE:
                Log.d("message", "handleButton [Created]: "+name.getValue());
                break;
            case UPDATE:
                Log.d("message", "handleButton [Update]: "+name.getValue());
                break;
        }
    }

}
