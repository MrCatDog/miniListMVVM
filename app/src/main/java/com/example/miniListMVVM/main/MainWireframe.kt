package com.example.miniListMVVM.main

import java.io.File

interface MainWireframe {
    enum class Direction {
        WATCH,
        EDIT,
        SETTINGS;
    }

    fun setExist()
    fun setNew()
    fun getFilesDir(): File
    fun changeActivity(direction: Direction)
}