package com.example.miniListMVVM.settings

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.RadioGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.miniListMVVM.databinding.ActivitySettingsBinding
import com.example.miniListMVVM.watch.WatchViewModel

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    private val viewModel: SettingsViewModel by viewModels {
        object : AbstractSavedStateViewModelFactory(this, null) {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                key: String,
                modelClass: Class<T>,
                handle: SavedStateHandle
            ): T {
                return SettingsViewModel(PreferenceManager.getDefaultSharedPreferences(this@SettingsActivity)) as T
            }
        }
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioTextSize.setOnCheckedChangeListener { _: RadioGroup, check: Int ->
            viewModel.changeSize(
                check
            )
        }
        binding.radioTextColor.setOnCheckedChangeListener { _: RadioGroup, check: Int ->
            viewModel.changeColor(
                check
            )
        }

        viewModel.colorRadio.observe(this) {
            binding.radioTextColor.check(it)
        }

        viewModel.sizeRadio.observe(this) {
            binding.radioTextSize.check(it)
        }
    }
}