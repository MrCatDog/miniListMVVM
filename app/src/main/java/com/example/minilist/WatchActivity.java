package com.example.minilist;

import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;

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
        presenter = new WatchPresenter(this, PreferenceManager.getDefaultSharedPreferences(this));
    }

    public void setText(String text) {
        binding.lineList.setText(text);
    }

    public void setTextColor(Color color) {
        binding.lineList.setTextColor(color.hashCode());
    }

    public void setTextSize(float size) {
        binding.lineList.setTextSize(size);
    }
}
