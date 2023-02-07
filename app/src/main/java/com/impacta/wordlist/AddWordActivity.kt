package com.impacta.wordlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.impacta.wordlist.databinding.ActivityAddWordBinding
import com.impacta.wordlist.model.Word
import com.impacta.wordlist.model.WordDao

class AddWordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddWordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddWordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this, WordViewModel.WordViewModelFactory(
            repository = (application as WordApplication).repository
        ))[WordViewModel::class.java]

        binding.buttonAdd.setOnClickListener {
            val word = binding.editTextAdd.text.toString()
            viewModel.insert(Word(word))
            Toast.makeText(this, "Item Adicionado", Toast.LENGTH_LONG).show()
        }
    }
}