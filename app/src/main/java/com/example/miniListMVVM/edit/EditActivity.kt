package com.example.miniListMVVM.edit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.miniListMVVM.databinding.EditActivityBinding

class EditActivity : AppCompatActivity(), EditWireframe {

    private lateinit var binding: EditActivityBinding
    private lateinit var presenter: EditPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EditActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = EditPresenter(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.saveText(binding.fileText.text.toString())
    }

    override fun setText(text: String) {
        binding.fileText.setText(text)
    }
}