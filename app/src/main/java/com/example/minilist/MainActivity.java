package com.example.minilist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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
    }

    public void setNew() {
        binding.editBtn.setVisibility(View.GONE);
        binding.showBtn.setText(R.string.create_btn_text);
    }

    public void setExist() {
        binding.editBtn.setVisibility(View.GONE);
        binding.showBtn.setText(R.string.create_btn_text);
        binding.editBtn.setOnClickListener(view -> presenter.editBtnClicked());
    }

    public void startEdit() {
        startActivity(new Intent(this, EditActivity.class));
    }
}
