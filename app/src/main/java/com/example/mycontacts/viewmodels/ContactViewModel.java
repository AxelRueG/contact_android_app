package com.example.mycontacts.viewmodels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mycontacts.models.Contact;
import com.example.mycontacts.config.DataBase;

import java.util.List;

public class ContactViewModel extends ViewModel {
    public final MutableLiveData<List<Contact>> contacts = new MutableLiveData<>();

    public void getAll() {
        DataBase.db.contactDao().insert(new Contact("pedro","342 543-4545","pedro@gmail.com",false));
        DataBase.db.contactDao().insert(new Contact("carla","342 543-4770","carla@gmail.com",false));

        List<Contact> contactsList = DataBase.db.contactDao().getAll();
        contacts.postValue(contactsList);
    }
}
