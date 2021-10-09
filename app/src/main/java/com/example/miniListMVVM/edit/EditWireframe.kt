package com.example.miniListMVVM.edit

import java.io.File

interface EditWireframe {
    fun setText(text: String)
    fun getFilesDir(): File
}