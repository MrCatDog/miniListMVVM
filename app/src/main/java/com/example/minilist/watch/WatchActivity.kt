package com.example.minilist.watch

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.example.minilist.databinding.ActivityWatchBinding
import java.io.File

class WatchActivity : AppCompatActivity(), WatchWireframe {

    private lateinit var binding: ActivityWatchBinding
    private lateinit var presenter: WatchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = WatchPresenter(this, PreferenceManager.getDefaultSharedPreferences(this))
    }

    override fun setText(text: String) {
        binding.lineList.text = text
    }

    override fun setTextColor(color: Int) {
        binding.lineList.setTextColor(resources.getColor(color))
    }

    override fun setTextSize(size: Int, dimension: Int) {
        binding.lineList.setTextSize(size, resources.getDimensionPixelSize(dimension).toFloat())
    }

    override fun getDir(): File = filesDir


}