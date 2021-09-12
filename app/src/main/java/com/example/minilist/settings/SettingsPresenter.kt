package com.example.minilist.settings

import android.content.SharedPreferences
import com.example.minilist.R

class SettingsPresenter internal constructor(wireframe: SettingsActivity, private val sharedPreferences: SharedPreferences) {

    companion object {
        const val LITTLE_SIZE = 0
        const val AVERAGE_SIZE = 1
        const val BIG_SIZE = 2
        const val BLACK_COLOR = 0
        const val UMBER_COLOR = 1
        const val GREEN_COLOR = 2
    }

    init {
        wireframe.setSizeRadio(when (sharedPreferences.getInt(SettingsActivity.SETTINGS_TEXT_SIZE, AVERAGE_SIZE)) {
            LITTLE_SIZE -> R.id.radio_little
            BIG_SIZE -> R.id.radio_big
            else -> R.id.radio_avg
        })
        wireframe.setColorRadio(when (sharedPreferences.getInt(SettingsActivity.SETTINGS_TEXT_COLOR, BLACK_COLOR)) {
            UMBER_COLOR -> R.id.radio_burnt_umber
            GREEN_COLOR -> R.id.radio_kashmir_green
            else -> R.id.radio_black
        })
    }

    fun changeSize(checkedRadioButtonId: Int) {
        sharedPreferences.edit().putInt(
                SettingsActivity.SETTINGS_TEXT_SIZE,
                when (checkedRadioButtonId) {
                    R.id.radio_little -> LITTLE_SIZE
                    R.id.radio_big -> BIG_SIZE
                    else -> AVERAGE_SIZE
                }
        ).apply()

        //не упала ли читаемость?

//        val size: Int = when (checkedRadioButtonId) {
//            R.id.radio_little -> LITTLE_SIZE
//            R.id.radio_big -> BIG_SIZE
//            else -> AVERAGE_SIZE
//        }
//        sharedPreferences.edit().putInt(SettingsActivity.SETTINGS_TEXT_SIZE, size).apply()
    }

    fun changeColor(checkedRadioButtonId: Int) {
        sharedPreferences.edit().putInt(SettingsActivity.SETTINGS_TEXT_COLOR, when (checkedRadioButtonId) {
            R.id.radio_burnt_umber -> UMBER_COLOR
            R.id.radio_kashmir_green -> GREEN_COLOR
            else -> BLACK_COLOR
        }).apply()
    }
}