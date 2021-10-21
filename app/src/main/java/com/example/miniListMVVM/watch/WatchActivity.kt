package com.example.miniListMVVM.watch

import android.os.Bundle
import android.preference.PreferenceManager
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import com.example.miniListMVVM.databinding.ActivityWatchBinding
import com.example.miniListMVVM.viewModelsExt

class WatchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWatchBinding

    private val viewModel by viewModelsExt {
        WatchViewModel(
            PreferenceManager.getDefaultSharedPreferences(this@WatchActivity),
            filesDir)
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