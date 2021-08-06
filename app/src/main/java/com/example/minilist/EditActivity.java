package com.example.minilist;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.minilist.databinding.EditActivityBinding;

public class EditActivity extends AppCompatActivity {

    public static final String EXTRA_ANSWER = "answer";

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
        //todo: file save с проверкой успеха, показываем снек с результатом
        presenter.saveText(binding.fileText.getText().toString());
        //setResult(RESULT_OK); //тут это не сработает. как и в методе выше!
    }

    public void setText(String text) {
        binding.fileText.setText(text);
    }

    public void failed(Intent intent) {
        setResult(AppCompatActivity.RESULT_CANCELED, intent);
        finish();
    }

    public void success() {
        setResult(RESULT_OK);
        finish();
    }
}
