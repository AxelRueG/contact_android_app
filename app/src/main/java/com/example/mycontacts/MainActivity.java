package com.example.mycontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.mycontacts.databinding.ActivityMainBinding;
import com.example.mycontacts.models.AppDatabase;
import com.example.mycontacts.models.Contact;
import com.example.mycontacts.models.ContactDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "contact_test_db"
        ).allowMainThreadQueries().build();
//
//        db.contactDao().insert(new Contact("pepe","123456","common.png"));
//        db.contactDao().insert(new Contact("jeje","123457","common.png"));
//        db.contactDao().insert(new Contact("pepa","123458","common.png"));

        List<Contact> contacts = db.contactDao().getAll();

        System.out.println("=====================================================================");
        System.out.println("length list: "+contacts.size());
        System.out.println("=====================================================================");

        StringBuilder msj = new StringBuilder("Lista de contactos:\n");

        for (Contact contact: contacts){
            msj.append(contact.name).append('\n');
        }

        binding.myTextView1.setText(msj.toString());
    }
}