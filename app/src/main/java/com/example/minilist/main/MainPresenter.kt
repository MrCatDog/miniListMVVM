package com.example.minilist.main

import java.io.File

class MainPresenter(private val wireframe: MainWireframe) {

    companion object {
        const val FILE_NAME = "miniList"
    }

    init {
        checkFileExists()
    }

    fun checkFileExists() {
        if (File(wireframe.getFilesDir(), FILE_NAME).exists()) {
            wireframe.setExist()
        } else {
            wireframe.setNew()
        }
    }

    fun onEditButtonClicked() {
        wireframe.changeActivity(MainWireframe.Direction.EDIT)
    }

    fun onNewButtonClicked() {
        wireframe.changeActivity(MainWireframe.Direction.EDIT)
    }

    fun onShowButtonClicked() {
        wireframe.changeActivity(MainWireframe.Direction.WATCH)
    }

    fun onSettingsButtonClicked() {
        wireframe.changeActivity(MainWireframe.Direction.SETTINGS)
    }
}