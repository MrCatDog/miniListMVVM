package com.example.minilist;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.minilist.databinding.EditActivityBinding;
import com.google.android.material.snackbar.Snackbar;

public class EditActivity extends AppCompatActivity {

    private EditActivityBinding binding;
    private EditActivityPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = EditActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onPause() {
        super.onPause();
        //todo: file save с проверкой успеха, показываем снек с результатом
    }

    public void showSnack() {
        //Snackbar.make(binding)
        //хуйня, здесь нужно вернуть результат в прошлую активити(true или false) и в зависимости от этого она будет выводить снэк с результатом
    }


}
