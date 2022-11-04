package com.example.mycontacts.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mycontacts.databinding.ActivityFormContactBinding;
import com.example.mycontacts.models.ContactModel;
import com.example.mycontacts.viewmodels.ContactViewModel;

public class FormContact extends AppCompatActivity implements View.OnClickListener {

    private ActivityFormContactBinding binding;
    private ContactViewModel contactViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);

        binding.addContact.setOnClickListener(this);
        binding.cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == binding.addContact.getId()){
            String name = binding.name.getText().toString();
            String number = binding.number.getText().toString();
            contactViewModel.addContact(name,number);
            Toast.makeText(getApplicationContext(),"contact: "+name+" addend",Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}