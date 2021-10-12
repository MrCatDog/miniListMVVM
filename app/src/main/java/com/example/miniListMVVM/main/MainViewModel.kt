package com.example.miniListMVVM.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.miniListMVVM.MutableLiveEvent
import com.example.miniListMVVM.Shared
import java.io.File

class MainViewModel(private val filesDir: File) : ViewModel() {

    enum class Direction {
        WATCH,
        EDIT,
        SETTINGS;
    }

    private val _isExists = MutableLiveData<Boolean>()
    private val _changeActivity = MutableLiveEvent<Direction>()

    val isExists: LiveData<Boolean>
        get() = _isExists

    val changeActivity: LiveData<Direction>
        get() = _changeActivity

    init {
        checkFileExists()
    }

    fun checkFileExists() {
        _isExists.value = File(filesDir, Shared.FILE_NAME).exists()
    }

    fun onEditButtonClicked() {
        _changeActivity.setValue(Direction.EDIT)
    }

    fun onNewButtonClicked() {
        _changeActivity.setValue(Direction.EDIT)
    }

    fun onShowButtonClicked() {
        _changeActivity.setValue(Direction.WATCH)
    }

    fun onSettingsButtonClicked() {
        _changeActivity.setValue(Direction.SETTINGS)
    }
}