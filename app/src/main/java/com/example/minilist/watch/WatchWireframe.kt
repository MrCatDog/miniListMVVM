package com.example.minilist.watch

import java.io.File

interface WatchWireframe {
    fun setText(text: String)
    fun setTextSize(size: Int, dimension: Int)
    fun setTextColor(color: Int)
    fun getFilesDir(): File
}