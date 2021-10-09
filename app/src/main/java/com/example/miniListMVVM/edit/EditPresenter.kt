package com.example.miniListMVVM.edit

import android.util.Log
import com.example.miniListMVVM.Shared
import java.io.*

class EditPresenter internal constructor(private val wireframe: EditWireframe) {

    init {
        val source = File(wireframe.getFilesDir(), Shared.FILE_NAME)
        if (source.exists()) {
            try {
                wireframe.setText(source.readText())
            } catch (ex: FileNotFoundException) {
                Log.e(Shared.LOG_TAG, ex.message ?: "Unknown error!")
            }
        }
    }

    fun saveText(text: String) {
        val file = File(wireframe.getFilesDir(), Shared.FILE_NAME)
        if (text.isEmpty()) {
            //del
            file.delete()
        } else {
            //save
            try {
                file.writeText(text)
            } catch (ex: IOException) {
                Log.e(Shared.LOG_TAG, ex.message ?: "Unknown error!")
            }
        }
    }
}