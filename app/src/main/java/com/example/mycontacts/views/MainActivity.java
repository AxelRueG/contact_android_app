package com.example.mycontacts.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mycontacts.databinding.ActivityMainBinding;
import com.example.mycontacts.models.ContactModel;
import com.example.mycontacts.viewmodels.ContactViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private ContactViewModel contactVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        contactVM = new ViewModelProvider(this).get(ContactViewModel.class);

        contactVM.contacts.observe(this, new Observer<List<ContactModel>>() {
            @Override
            public void onChanged(List<ContactModel> contactModels) {
                StringBuilder message = new StringBuilder();
                contactModels.forEach(contact -> message.append(contact.name).append("\n"));
                binding.myTextView1.setText(message.toString());
            }
        });

        contactVM.getAll();

        binding.floatingActionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), FormContact.class);
        startActivity(intent);
    }
}
