package com.example.mycontacts.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mycontacts.databinding.ActivityAddContactBinding;

public class AddContact extends AppCompatActivity implements View.OnClickListener {

    private ActivityAddContactBinding binding;
//    private ContactViewModel contactViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);
//        contactViewModel.contacts.observe(this, new Observer<List<ContactModel>>() {
//            @Override
//            public void onChanged(List<ContactModel> contactModels) {
//
//            }
//        });

    }

    @Override
    public void onClick(View view) {
//        if (view.getId() == binding.addContact.getId()){
//            Toast.makeText(getApplicationContext(),"adding contact", Toast.LENGTH_SHORT).show();
//        } else if (view.getId() == binding.cancel.getId()) {
//            Toast.makeText(getApplicationContext(),"cancel", Toast.LENGTH_SHORT).show();
//        }
    }
}