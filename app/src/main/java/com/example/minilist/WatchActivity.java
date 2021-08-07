package com.example.minilist;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.minilist.databinding.ActivityWatchBinding;

public class WatchActivity extends AppCompatActivity {

    private ActivityWatchBinding binding;
    private WatchPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWatchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new WatchPresenter(this);
    }

    public void setText(String text) {
        binding.lineList.setText(text);
    }
}
