package com.example.minilist.watch

import android.content.SharedPreferences
import com.example.minilist.R
import com.example.minilist.Shared
import com.example.minilist.main.MainPresenter
import com.example.minilist.settings.SettingsActivity
import com.example.minilist.settings.SettingsPresenter
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

class WatchPresenter(private val wireframe: WatchWireframe, sharedPreferences: SharedPreferences) {

    init {
        wireframe.setTextColor(when (sharedPreferences.getInt(Shared.SETTINGS_TEXT_COLOR, Shared.BLACK_COLOR)) {
            Shared.UMBER_COLOR -> R.color.burnt_umber
            Shared.GREEN_COLOR -> R.color.kashmir_green
            else -> R.color.black
        })

        wireframe.setTextSize(when (sharedPreferences.getInt(Shared.SETTINGS_TEXT_SIZE, Shared.AVERAGE_SIZE)) {
            Shared.LITTLE_SIZE -> R.dimen.little_text_size
            Shared.BIG_SIZE -> R.dimen.big_text_size
            else -> R.dimen.average_text_size
        })

        try {
            val stringBuilder = StringBuilder()
            var i = 0
            File(wireframe.getFilesDir(), Shared.FILE_NAME).forEachLine {
                stringBuilder.append(++i).append(it).append("\n")
            }
            wireframe.setText(stringBuilder.toString())
//            BufferedReader(FileReader(File(wireframe.getFilesDir(), MainPresenter.FILE_NAME))).use {
//                val stringBuilder = StringBuilder()
//                var i = 0
//                File(wireframe.getFilesDir(), MainPresenter.FILE_NAME).forEachLine {
//                    stringBuilder.append(++i).append(it).append("\n")
//                }
//                wireframe.setText(stringBuilder.toString())
//            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
    }
}