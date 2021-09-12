package com.example.minilist.settings

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.minilist.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var presenter: SettingsPresenter
    private lateinit var binding: ActivitySettingsBinding

    companion object {
        const val SETTINGS_TEXT_COLOR = "text_color"
        const val SETTINGS_TEXT_SIZE = "text_size"
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = SettingsPresenter(this, PreferenceManager.getDefaultSharedPreferences(this))
        binding.radioTextSize.setOnCheckedChangeListener { _: RadioGroup, check: Int -> presenter.changeSize(check) }
        binding.radioTextColor.setOnCheckedChangeListener { _: RadioGroup, check: Int -> presenter.changeColor(check) }
    }

    fun setSizeRadio(buttonID: Int) {
        binding.radioTextSize.check(buttonID)
    }

    fun setColorRadio(buttonID: Int) {
        binding.radioTextColor.check(buttonID)
    }
}