package com.example.minilist;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.minilist.databinding.ActivitySettingsBinding;

public class SettingsActivity extends AppCompatActivity {

    private SettingsPresenter presenter;
    private ActivitySettingsBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new SettingsPresenter(this);
    }
}