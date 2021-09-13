package com.example.minilist.edit

import com.example.minilist.Shared
import com.example.minilist.main.MainPresenter
import java.io.*
import java.util.*

class EditActivityPresenter internal constructor(private val wireframe: EditWireframe) {

    init {
        val source = File(wireframe.getFilesDir(), Shared.FILE_NAME)
        if (source.exists()) {
            try {
                wireframe.setText(source.readText())
            } catch (exception: FileNotFoundException) {
                exception.printStackTrace()
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
            } catch (ioe: IOException) {
                ioe.printStackTrace()
            }
        }
    }
}