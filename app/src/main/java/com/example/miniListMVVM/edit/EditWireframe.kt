package com.example.minilist.edit

import java.io.File

interface EditWireframe {
    fun setText(text: String)
    fun getFilesDir(): File
}