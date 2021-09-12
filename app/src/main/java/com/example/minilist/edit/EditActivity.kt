package com.example.minilist.edit;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.minilist.databinding.EditActivityBinding;

public class EditActivity extends AppCompatActivity {

    private EditActivityBinding binding;
    private EditActivityPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = EditActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new EditActivityPresenter(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.saveText(binding.fileText.getText().toString());
    }

    public void setText(String text) {
        binding.fileText.setText(text);
    }

}
