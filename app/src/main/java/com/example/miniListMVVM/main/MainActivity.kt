package com.example.miniListMVVM.main

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.miniListMVVM.R
import com.example.miniListMVVM.databinding.ActivityMainBinding
import com.example.miniListMVVM.edit.EditActivity
import com.example.miniListMVVM.main.MainViewModel.Direction.*
import com.example.miniListMVVM.settings.SettingsActivity
import com.example.miniListMVVM.settings.SettingsViewModel
import com.example.miniListMVVM.viewModelsExt
import com.example.miniListMVVM.watch.WatchActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModelsExt {
        MainViewModel(filesDir)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showBtn.setOnClickListener { viewModel.onShowButtonClicked() }
        binding.settingsBtn.setOnClickListener { viewModel.onSettingsButtonClicked() }
        binding.newOrEditBtn.setOnClickListener { viewModel.onNewOrEditButtonClicked() }

        viewModel.isExists.observe(this) {
            if (it) {
                binding.newOrEditBtn.setText(R.string.edit_btn_text)
                binding.showBtn.visibility = View.VISIBLE
            } else {
                binding.newOrEditBtn.setText(R.string.create_btn_text)
                binding.showBtn.visibility = View.GONE
            }
        }

        viewModel.changeActivity.observe(this) { direction: MainViewModel.Direction ->
            when (direction) {
                SETTINGS -> startActivity(Intent(this, SettingsActivity::class.java))
                WATCH -> startActivity(Intent(this, WatchActivity::class.java))
                EDIT -> startActivity(Intent(this, EditActivity::class.java))
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.checkFileExists()
    }
}