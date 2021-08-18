package com.example.minilist;

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

    public void setTextColor(int color) {
        binding.lineList.setTextColor(color);
    }

    public void setTextSize(int size, float dimension) {
        binding.lineList.setTextSize(size, dimension);
    }
}
