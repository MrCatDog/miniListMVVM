package com.example.miniListMVVM.settings

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.miniListMVVM.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity(), SettingsWireframe {

    private lateinit var presenter: SettingsPresenter
    private lateinit var binding: ActivitySettingsBinding

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = SettingsPresenter(this, PreferenceManager.getDefaultSharedPreferences(this))
        binding.radioTextSize.setOnCheckedChangeListener { _: RadioGroup, check: Int -> presenter.changeSize(check) }
        binding.radioTextColor.setOnCheckedChangeListener { _: RadioGroup, check: Int -> presenter.changeColor(check) }
    }

    override fun setSizeRadio(sizeId: Int) {
        binding.radioTextSize.check(sizeId)
    }

    override fun setColorRadio(colorId: Int) {
        binding.radioTextColor.check(colorId)
    }
}