package com.example.miniListMVVM.watch

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.miniListMVVM.R
import com.example.miniListMVVM.Shared

class WatchViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {

    private val _size = MutableLiveData<Int>()

    private val _color = MutableLiveData<Int>()

    val size: LiveData<Int>
        get() = _size

    val color: LiveData<Int>
        get() = _color

    init {
        _size.value = loadSize()
        _color.value = loadColor()


    }

    private fun loadColor() = when (sharedPreferences.getInt(Shared.SETTINGS_TEXT_COLOR, Shared.COLOR_BLACK)) {
        Shared.COLOR_UMBER -> R.color.burnt_umber
        Shared.COLOR_GREEN -> R.color.kashmir_green
        else -> R.color.black
    }

    private fun loadSize() = when (sharedPreferences.getInt(Shared.SETTINGS_TEXT_SIZE, Shared.SIZE_AVERAGE)) {
        Shared.SIZE_LITTLE -> R.dimen.little_text_size
        Shared.SIZE_BIG -> R.dimen.big_text_size
        else -> R.dimen.average_text_size
    }
}