package com.example.miniListMVVM.settings

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.miniListMVVM.R
import com.example.miniListMVVM.Shared

class SettingsViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {
    private val _colorRadio = MutableLiveData<Int>()
    private val _sizeRadio = MutableLiveData<Int>()

    val sizeRadio: LiveData<Int>
        get() = _sizeRadio
    val colorRadio: LiveData<Int>
        get() = _colorRadio

    init {
        _colorRadio.value = loadColor()
        _sizeRadio.value = loadSize()
    }

    fun changeSize(checkedRadioButtonId: Int) {
        sharedPreferences.edit()
            .putInt(
                Shared.SETTINGS_TEXT_SIZE,
                when (checkedRadioButtonId) {
                    R.id.radio_little -> Shared.SIZE_LITTLE
                    R.id.radio_big -> Shared.SIZE_BIG
                    else -> Shared.SIZE_AVERAGE
                }
            )
            .apply()
    }

    fun changeColor(checkedRadioButtonId: Int) {
        sharedPreferences.edit().putInt(
            Shared.SETTINGS_TEXT_COLOR, when (checkedRadioButtonId) {
                R.id.radio_burnt_umber -> Shared.COLOR_UMBER
                R.id.radio_kashmir_green -> Shared.COLOR_GREEN
                else -> Shared.COLOR_BLACK
            }
        ).apply()
    }

    private fun loadSize() =
        when (sharedPreferences.getInt(Shared.SETTINGS_TEXT_SIZE, Shared.SIZE_AVERAGE)) {
            Shared.SIZE_LITTLE -> R.id.radio_little
            Shared.SIZE_BIG -> R.id.radio_big
            else -> R.id.radio_avg
        }

    private fun loadColor() =
        when (sharedPreferences.getInt(Shared.SETTINGS_TEXT_COLOR, Shared.COLOR_BLACK)) {
            Shared.COLOR_UMBER -> R.id.radio_burnt_umber
            Shared.COLOR_GREEN -> R.id.radio_kashmir_green
            else -> R.id.radio_black
        }
}