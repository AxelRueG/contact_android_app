package com.example.mycontacts.viewmodels;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mycontacts.config.DataBase;
import com.example.mycontacts.models.Contact;
import com.example.mycontacts.room.AppDatabase;
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
                try {
                DataBase.db.contactDao().insert(
                        new Contact(name.getValue(),number.getValue(),email.getValue(), Boolean.TRUE.equals(favorite.getValue()))
                        );
                    operationResult.setValue(Boolean.TRUE);
                } catch (Exception e) {
                    operationResult.setValue(Boolean.FALSE);
                }
                break;
            case UPDATE:
                Log.d("message", "handleButton [Update]: "+name.getValue());
                break;
        }
    }
}
