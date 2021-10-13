package com.example.miniListMVVM.watch

import android.os.Bundle
import android.preference.PreferenceManager
import android.util.TypedValue
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.miniListMVVM.databinding.ActivityWatchBinding

class WatchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWatchBinding

    private val viewModel: WatchViewModel by viewModels {
        object : AbstractSavedStateViewModelFactory(this, null) {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                key: String,
                modelClass: Class<T>,
                handle: SavedStateHandle
            ): T {
                return WatchViewModel(
                    PreferenceManager.getDefaultSharedPreferences(this@WatchActivity),
                    filesDir
                ) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.color.observe(this) {
            binding.lineList.setTextColor(resources.getColor(it))
        }

        viewModel.size.observe(this) {
            binding.lineList.setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                resources.getDimensionPixelSize(it).toFloat()
            )
        }

        viewModel.text.observe(this) {
            binding.lineList.text = it
        }
    }
}