package com.example.minilist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.minilist.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new MainPresenter(this);

        binding.editBtn.setOnClickListener(view -> presenter.onEditButtonClicked());
        binding.settingsBtn.setOnClickListener(view -> presenter.onSettingsButtonClicked());
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.checkFileExists();
    }

    public void setNew() {
        binding.showNewBtn.setText(R.string.create_btn_text);
        binding.showNewBtn.setOnClickListener(view -> presenter.onNewButtonClicked());
        binding.editBtn.setVisibility(View.GONE);
    }

    public void setExist() {
        binding.showNewBtn.setText(R.string.show_btn_text);
        binding.showNewBtn.setOnClickListener(view -> presenter.onShowButtonClicked());
        binding.editBtn.setVisibility(View.VISIBLE);
    }

    public void startEdit() {
        startActivity(new Intent(this, EditActivity.class));
    }

    public void startViewing() {
        startActivity(new Intent(this, WatchActivity.class));
    }
}
