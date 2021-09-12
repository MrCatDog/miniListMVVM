package com.example.minilist.edit

import com.example.minilist.main.MainPresenter
import java.io.*
import java.util.*

class EditActivityPresenter internal constructor(private val wireframe: EditWireframe) {

    init {
        val source = File(wireframe.getFilesDir(), MainPresenter.FILE_NAME)
        if (source.exists()) {
            try {
                Scanner(source).use { input -> wireframe.setText(input.useDelimiter("\\Z").next()) }
            } catch (exception: FileNotFoundException) {
                exception.printStackTrace()
            }
        }
    }

    fun saveText(text: String) {
        val file = File(wireframe.getFilesDir(), MainPresenter.FILE_NAME)
        if (text.isEmpty()) {
            //del
            file.delete()
        } else {
            //save
            try {
                BufferedWriter(FileWriter(file)).use { out -> out.write(text) }
            } catch (ioe: IOException) {
                ioe.printStackTrace()
            }
        }
    }
}