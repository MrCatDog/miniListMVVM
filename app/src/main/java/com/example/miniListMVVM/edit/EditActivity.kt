package com.example.miniListMVVM.edit

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.miniListMVVM.databinding.EditActivityBinding
import com.example.miniListMVVM.main.MainViewModel
import com.example.miniListMVVM.viewModelsExt

class EditActivity : AppCompatActivity() {

    private lateinit var binding: EditActivityBinding

    private val viewModel by viewModelsExt {
        EditViewModel(filesDir)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EditActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.text.observe(this) {
            binding.fileText.setText(it)
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.saveText(binding.fileText.text.toString())
    }

}