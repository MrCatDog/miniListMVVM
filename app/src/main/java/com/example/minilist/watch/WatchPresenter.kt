package com.example.minilist.watch

import android.content.SharedPreferences
import com.example.minilist.R
import com.example.minilist.main.MainPresenter
import com.example.minilist.settings.SettingsActivity
import com.example.minilist.settings.SettingsPresenter
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

class WatchPresenter(private val wireframe: WatchWireframe, sharedPreferences: SharedPreferences) {

    init {
        wireframe.setTextColor(when (sharedPreferences.getInt(SettingsActivity.SETTINGS_TEXT_COLOR, SettingsPresenter.BLACK_COLOR)) {
            SettingsPresenter.UMBER_COLOR -> R.color.burnt_umber
            SettingsPresenter.GREEN_COLOR -> R.color.kashmir_green
            else -> R.color.black
        })

        wireframe.setTextSize(when (sharedPreferences.getInt(SettingsActivity.SETTINGS_TEXT_SIZE, SettingsPresenter.AVERAGE_SIZE)) {
            SettingsPresenter.LITTLE_SIZE -> R.dimen.little_text_size
            SettingsPresenter.BIG_SIZE -> R.dimen.big_text_size
            else -> R.dimen.average_text_size
        })

        try {
            BufferedReader(FileReader(File(wireframe.getFilesDir(), MainPresenter.FILE_NAME))).use { input ->
                val stringBuilder = StringBuilder()
                var line: String?
                var i = 0
                while (input.readLine().also { line = it } != null) {
                    stringBuilder.append(++i).append(line).append("\n")
                }
                wireframe.setText(stringBuilder.toString())
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
    }
}