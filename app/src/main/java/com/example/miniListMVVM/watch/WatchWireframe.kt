package com.example.miniListMVVM.watch

import java.io.File

interface WatchWireframe {
    fun setText(text: String)
    fun setTextSize(dimension: Int)
    fun setTextColor(color: Int)
    fun getFilesDir(): File
}