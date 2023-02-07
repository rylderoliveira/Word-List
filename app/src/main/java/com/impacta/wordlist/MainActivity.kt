package com.impacta.wordlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.impacta.wordlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = WordAdapter()
    private lateinit var viewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        initRecyclerView()
        initListeners()
        initObservers()
    }

    private fun initObservers() {
        viewModel.allWords.observe(this) { words ->
            adapter.items = words
            adapter.notifyDataSetChanged()
        }
    }

    private fun initListeners() {
        binding.floatingActionButtonMain.setOnClickListener {
            val intent = Intent(this, AddWordActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerView() {
        binding.recyclerViewMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewMain.adapter = adapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, WordViewModel.WordViewModelFactory(
            repository = (application as WordApplication).repository
        ))[WordViewModel::class.java]
    }
}