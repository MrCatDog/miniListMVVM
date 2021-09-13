package com.example.minilist.main

import com.example.minilist.Shared
import java.io.File

class MainPresenter(private val wireframe: MainWireframe) {

    init {
        checkFileExists()
    }

    fun checkFileExists() {
        if (File(wireframe.getFilesDir(), Shared.FILE_NAME).exists()) {
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