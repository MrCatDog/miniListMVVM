package com.example.minilist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.minilist.databinding.NewFileFragmentBinding;

import org.jetbrains.annotations.NotNull;

public class NewFragment extends Fragment {

    public static final String filename = "data.txt";

    private NewFileFragmentBinding binding;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = NewFileFragmentBinding.inflate(inflater);

        binding.createBtn.setOnClickListener(unused -> {
            //создание файла
        });

        binding.settingsBtn.setOnClickListener(unused -> {
            //вызов настроек
        });

        return binding.getRoot();
    }
}
