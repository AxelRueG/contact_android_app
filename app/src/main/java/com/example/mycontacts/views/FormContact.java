package com.example.mycontacts.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

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
                    showMessage("the user wasn't created");
                }
            }
        });
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