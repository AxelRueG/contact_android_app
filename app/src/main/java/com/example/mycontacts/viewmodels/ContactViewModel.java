package com.example.mycontacts.viewmodels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mycontacts.models.Contact;
import com.example.mycontacts.room.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class ContactViewModel extends ViewModel {
    public final MutableLiveData<List<Contact>> contacts = new MutableLiveData<>();

    public void getAll(Context context) {
        List<Contact> contactsList = AppDatabase.getInstance(context).contactDao().getAll();
        contacts.postValue(contactsList);
    }
}
