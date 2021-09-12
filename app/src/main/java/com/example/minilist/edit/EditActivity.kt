package com.example.minilist.edit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minilist.databinding.EditActivityBinding

class EditActivity : AppCompatActivity(), EditWireframe {

    private lateinit var binding: EditActivityBinding
    private lateinit var presenter: EditActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EditActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = EditActivityPresenter(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.saveText(binding.fileText.text.toString())
    }

    override fun setText(text: String) {
        binding.fileText.setText(text)
    }
}