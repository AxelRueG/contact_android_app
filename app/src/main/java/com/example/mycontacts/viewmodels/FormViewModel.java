package com.example.mycontacts.viewmodels;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mycontacts.config.DataBase;
import com.example.mycontacts.config.Operations;
import com.example.mycontacts.models.Contact;

public class FormViewModel extends ViewModel {
    public MutableLiveData<Integer> id = new MutableLiveData<>();
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> number = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<Boolean> favorite = new MutableLiveData<>();
    public MutableLiveData<Boolean> operationResult = new MutableLiveData<>();

    public void handleCreated() {
        try {
            DataBase.db.contactDao().insert(
                    new Contact(name.getValue(), number.getValue(), email.getValue(), Boolean.TRUE.equals(favorite.getValue()))
            );
            operationResult.setValue(Boolean.TRUE);
        } catch (Exception e) {
            operationResult.setValue(Boolean.FALSE);
        }
    }

    public void handleDelete() {
        try {
            Contact contact = new Contact(name.getValue(), number.getValue(), email.getValue(), Boolean.TRUE.equals(favorite.getValue()));
            contact.id = id.getValue();
            DataBase.db.contactDao().delete(contact);
            operationResult.setValue(Boolean.TRUE);
        } catch (Exception e) {
            operationResult.setValue(Boolean.FALSE);
        }
    }

    public void handleUpdate() {
        try {
            Contact contact = new Contact(name.getValue(), number.getValue(), email.getValue(), Boolean.TRUE.equals(favorite.getValue()));
            contact.id = id.getValue();
            DataBase.db.contactDao().update(contact);
            operationResult.setValue(Boolean.TRUE);
        } catch (Exception e) {
            operationResult.setValue(Boolean.FALSE);
        }
    }

    public void loadContact(int contactId) {
        try {
            Contact contact = DataBase.db.contactDao().getContact(contactId);
            id.setValue(contact.id);
            name.setValue(contact.name);
            number.setValue(contact.number);
            email.setValue(contact.email);
            favorite.setValue(contact.favorite);
        } catch (Exception e) {
            operationResult.setValue(Boolean.FALSE);
        }
    }
}
