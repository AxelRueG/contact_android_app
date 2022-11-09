package com.example.mycontacts.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mycontacts.config.Operations;
import com.example.mycontacts.databinding.ActivityFormContactBinding;
import com.example.mycontacts.viewmodels.FormViewModel;

public class FormContact extends AppCompatActivity {

    private ActivityFormContactBinding binding;
    private FormViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(FormViewModel.class);
        binding.setModelo(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.operationResult.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    showMessage("the user was created successfully");
                    goHome();
                } else {
                    showMessage("something went wrong");
                }
            }
        });

        Operations ope = (Operations) this.getIntent().getSerializableExtra("operation");
        if (ope == Operations.CREATE) {
            binding.buttonsEdit.setVisibility(View.GONE);
            binding.addContact.setVisibility(View.VISIBLE);
        } else {
            binding.buttonsEdit.setVisibility(View.VISIBLE);
            binding.addContact.setVisibility(View.GONE);
            int contactId = this.getIntent().getIntExtra("id",0);
            viewModel.loadContact(contactId);
        }
    }

    private void showMessage(String s){
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }

    private void goHome() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}