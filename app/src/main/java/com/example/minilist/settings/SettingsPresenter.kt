package com.example.minilist.settings

import android.content.SharedPreferences
import com.example.minilist.R
import com.example.minilist.Shared

class SettingsPresenter internal constructor(wireframe: SettingsWireframe, private val sharedPreferences: SharedPreferences) {

    init {
        wireframe.setSizeRadio(when (sharedPreferences.getInt(SettingsActivity.SETTINGS_TEXT_SIZE, Shared.AVERAGE_SIZE)) {
            Shared.LITTLE_SIZE -> R.id.radio_little
            Shared.BIG_SIZE -> R.id.radio_big
            else -> R.id.radio_avg
        })
        wireframe.setColorRadio(when (sharedPreferences.getInt(SettingsActivity.SETTINGS_TEXT_COLOR, Shared.BLACK_COLOR)) {
            Shared.UMBER_COLOR -> R.id.radio_burnt_umber
            Shared.GREEN_COLOR -> R.id.radio_kashmir_green
            else -> R.id.radio_black
        })
    }

    fun changeSize(checkedRadioButtonId: Int) {
        sharedPreferences.edit()
                .putInt(
                        SettingsActivity.SETTINGS_TEXT_SIZE,
                        when (checkedRadioButtonId) {
                            R.id.radio_little -> Shared.LITTLE_SIZE
                            R.id.radio_big -> Shared.BIG_SIZE
                            else -> Shared.AVERAGE_SIZE
                        }
                )
                .apply()
    }

    fun changeColor(checkedRadioButtonId: Int) {
        sharedPreferences.edit().putInt(SettingsActivity.SETTINGS_TEXT_COLOR, when (checkedRadioButtonId) {
            R.id.radio_burnt_umber -> Shared.UMBER_COLOR
            R.id.radio_kashmir_green -> Shared.GREEN_COLOR
            else -> Shared.BLACK_COLOR
        }).apply()
    }
}