package com.example.mycontacts.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mycontacts.models.ContactModel;
import com.example.mycontacts.models.MyDB;

import java.util.ArrayList;
import java.util.List;

public class ContactViewModel extends ViewModel {
    public final MutableLiveData<List<ContactModel>> contacts = new MutableLiveData<>();

    public void getAll() {
        ArrayList<ContactModel> currentContacts = MyDB.getAll();
        contacts.postValue(currentContacts);
    }

    public void addContact() {}
}
