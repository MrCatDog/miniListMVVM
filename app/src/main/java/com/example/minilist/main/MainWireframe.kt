package com.example.minilist.main

import java.io.File

interface MainWireframe {
    enum class Direction {
        WATCH,
        EDIT,
        SETTINGS;
    }

    fun setExist()
    fun setNew()
    fun getDir(): File
    fun changeActivity(direction: Direction)
}