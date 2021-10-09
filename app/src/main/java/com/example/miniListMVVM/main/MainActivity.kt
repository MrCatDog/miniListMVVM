package com.example.miniListMVVM.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.miniListMVVM.R
import com.example.miniListMVVM.watch.WatchActivity
import com.example.miniListMVVM.main.MainWireframe.Direction.*
import com.example.miniListMVVM.edit.EditActivity
import com.example.miniListMVVM.settings.SettingsActivity
import com.example.miniListMVVM.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainWireframe {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainPresenter(this)
        binding.editBtn.setOnClickListener { presenter.onEditButtonClicked() }
        binding.settingsBtn.setOnClickListener { presenter.onSettingsButtonClicked() }
    }

    override fun onResume() {
        super.onResume()
        presenter.checkFileExists()
    }

    override fun setNew() {
        binding.showNewBtn.setText(R.string.create_btn_text)
        binding.showNewBtn.setOnClickListener { presenter.onNewButtonClicked() }
        binding.editBtn.visibility = View.GONE
    }

    override fun setExist() {
        binding.showNewBtn.setText(R.string.show_btn_text)
        binding.showNewBtn.setOnClickListener { presenter.onShowButtonClicked() }
        binding.editBtn.visibility = View.VISIBLE
    }

    override fun changeActivity(direction: MainWireframe.Direction) =
            when (direction) {
                SETTINGS -> startActivity(Intent(this, SettingsActivity::class.java))
                WATCH -> startActivity(Intent(this, WatchActivity::class.java))
                EDIT -> startActivity(Intent(this, EditActivity::class.java))
            }
}