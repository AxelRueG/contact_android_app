package com.example.mycontacts.models;

import java.util.ArrayList;
import java.util.List;

public class MyDB {
    public static ArrayList<ContactModel> contacts = new ArrayList<ContactModel>() {{
        add(new ContactModel(1,"Neutro","342 525-3312","undefined"));
        add(new ContactModel(1,"Rasta","342 525-3313","undefined"));
        add(new ContactModel(1,"Salta","342 525-3314","undefined"));
        add(new ContactModel(1,"Ana","342 525-3315","undefined"));
    }};

    public static ArrayList<ContactModel> getAll(){
        return contacts;
    }

    public static void add(ContactModel contact){
        contacts.add(contact);
    }
}
