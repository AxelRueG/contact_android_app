package com.example.mycontacts.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mycontacts.databinding.ActivityFormContactBinding;

public class FormContact extends AppCompatActivity implements View.OnClickListener {

    private ActivityFormContactBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.screen.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();
    }
}