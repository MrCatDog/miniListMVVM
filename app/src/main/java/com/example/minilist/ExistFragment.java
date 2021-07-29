package com.example.minilist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import com.example.minilist.databinding.ExistFileFragmentBinding;

public class ExistFragment extends Fragment {

    private ExistFileFragmentBinding binding;
    private ExistFragmentPresenter presenter;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = ExistFileFragmentBinding.inflate(inflater);
        presenter = new ExistFragmentPresenter(this);

        binding.showBtn.setOnClickListener(view -> presenter.onShowButtonClicked());

        binding.editBtn.setOnClickListener(view -> presenter.onEditButtonClicked());

        binding.settingsBtn.setOnClickListener(view -> presenter.onSettingsButtonClicked());

        return binding.getRoot();
    }

    public void startCalcScreen() {
        ((MainActivity) requireActivity()).startEdit();
    }
}
