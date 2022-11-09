package com.example.mycontacts.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mycontacts.adapter.ContactAdapter;
import com.example.mycontacts.databinding.ActivityMainBinding;
import com.example.mycontacts.models.Contact;
import com.example.mycontacts.viewmodels.ContactViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private ContactViewModel contactVM;
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        contactVM = new ViewModelProvider(this).get(ContactViewModel.class);

        contactVM.contacts.observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                contactAdapter = new ContactAdapter(contacts, getApplicationContext());
                binding.recyclerView.setAdapter(contactAdapter);
            }
        });

        contactVM.getAll(getApplicationContext());

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.floatingActionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), FormContact.class);
        startActivity(intent);
    }
}
