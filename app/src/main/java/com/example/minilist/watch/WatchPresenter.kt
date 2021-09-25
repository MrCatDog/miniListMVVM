package com.example.minilist.watch

import android.content.SharedPreferences
import com.example.minilist.R
import com.example.minilist.Shared
import java.io.File
import java.io.IOException

class WatchPresenter(private val wireframe: WatchWireframe, sharedPreferences: SharedPreferences) {

    init {
        wireframe.setTextColor(when (sharedPreferences.getInt(Shared.SETTINGS_TEXT_COLOR, Shared.COLOR_BLACK)) {
            Shared.COLOR_UMBER -> R.color.burnt_umber
            Shared.COLOR_GREEN -> R.color.kashmir_green
            else -> R.color.black
        })

        wireframe.setTextSize(when (sharedPreferences.getInt(Shared.SETTINGS_TEXT_SIZE, Shared.SIZE_AVERAGE)) {
            Shared.SIZE_LITTLE -> R.dimen.little_text_size
            Shared.SIZE_BIG -> R.dimen.big_text_size
            else -> R.dimen.average_text_size
        })

        try {
            val stringBuilder = StringBuilder()
            var i = 0
            File(wireframe.getFilesDir(), Shared.FILE_NAME).forEachLine {
                stringBuilder.append(++i).append(". ").append(it).append("\n")
            }
            wireframe.setText(stringBuilder.toString())
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }
}