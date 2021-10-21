package com.example.miniListMVVM.edit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.miniListMVVM.Shared
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

class EditViewModel(private val filesDir: File) : ViewModel() {

    private val _text = MutableLiveData<String>()

    val text: LiveData<String>
        get() = _text

    init {
        val source = File(filesDir, Shared.FILE_NAME)
        if (source.exists()) {
            try {
                _text.value = source.readText()
            } catch (ex: FileNotFoundException) {
                Log.e(Shared.LOG_TAG, ex.message, ex)
            }
        }
    }

    fun saveText(text: String) {
        val file = File(filesDir, Shared.FILE_NAME)
        if (text.isEmpty()) {
            //del
            file.delete()
        } else {
            //save
            try {
                file.writeText(text)
            } catch (ex: IOException) {
                Log.e(Shared.LOG_TAG, ex.message, ex)
            }
        }
    }
}