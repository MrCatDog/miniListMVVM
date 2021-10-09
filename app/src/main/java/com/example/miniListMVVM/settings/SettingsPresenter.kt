package com.example.miniListMVVM.settings

import android.content.SharedPreferences
import com.example.miniListMVVM.R
import com.example.miniListMVVM.Shared

class SettingsPresenter internal constructor(wireframe: SettingsWireframe, private val sharedPreferences: SharedPreferences) {

    init {
        wireframe.setSizeRadio(when (sharedPreferences.getInt(Shared.SETTINGS_TEXT_SIZE, Shared.SIZE_AVERAGE)) {
            Shared.SIZE_LITTLE -> R.id.radio_little
            Shared.SIZE_BIG -> R.id.radio_big
            else -> R.id.radio_avg
        })
        wireframe.setColorRadio(when (sharedPreferences.getInt(Shared.SETTINGS_TEXT_COLOR, Shared.COLOR_BLACK)) {
            Shared.COLOR_UMBER -> R.id.radio_burnt_umber
            Shared.COLOR_GREEN -> R.id.radio_kashmir_green
            else -> R.id.radio_black
        })
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
        sharedPreferences.edit().putInt(Shared.SETTINGS_TEXT_COLOR, when (checkedRadioButtonId) {
            R.id.radio_burnt_umber -> Shared.COLOR_UMBER
            R.id.radio_kashmir_green -> Shared.COLOR_GREEN
            else -> Shared.COLOR_BLACK
        }).apply()
    }
}