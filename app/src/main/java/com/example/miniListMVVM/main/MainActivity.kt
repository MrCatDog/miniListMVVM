package com.example.miniListMVVM.main

import android.content.Intent
import android.os.Bundle
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
import com.example.miniListMVVM.watch.WatchActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels {
        object : AbstractSavedStateViewModelFactory(this, null) {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
                return MainViewModel(filesDir) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editBtn.setOnClickListener { viewModel.onEditButtonClicked() }
        binding.settingsBtn.setOnClickListener { viewModel.onSettingsButtonClicked() }

        viewModel.isExists.observe(this) {
            if (it) {
                binding.showNewBtn.setText(R.string.show_btn_text)
                binding.showNewBtn.setOnClickListener { viewModel.onShowButtonClicked() }
                binding.editBtn.visibility = View.VISIBLE
            } else {
                binding.showNewBtn.setText(R.string.create_btn_text)
                binding.showNewBtn.setOnClickListener { viewModel.onNewButtonClicked() }
                binding.editBtn.visibility = View.GONE
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