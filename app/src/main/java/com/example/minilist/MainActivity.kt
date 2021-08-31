package com.example.minilist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.minilist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
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

    fun setNew() {
        binding.showNewBtn.setText(R.string.create_btn_text)
        binding.showNewBtn.setOnClickListener { view: View? -> presenter.onNewButtonClicked() }
        binding.editBtn.visibility = View.GONE
    }

    fun setExist() {
        binding.showNewBtn.setText(R.string.show_btn_text)
        binding.showNewBtn.setOnClickListener { view: View? -> presenter.onShowButtonClicked() }
        binding.editBtn.visibility = View.VISIBLE
    }
}