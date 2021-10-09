package com.example.miniListMVVM.main

import com.example.miniListMVVM.Shared
import java.io.File

class MainPresenter internal constructor(private val wireframe: MainWireframe) {

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