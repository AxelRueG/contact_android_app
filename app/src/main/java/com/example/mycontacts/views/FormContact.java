package com.example.mycontacts.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

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
    }
}