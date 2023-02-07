package com.impacta.wordlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.impacta.wordlist.model.Word
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository) : ViewModel() {

    val allWords: LiveData<List<Word>> = repository.allWords

    fun insert(word: Word) {
        viewModelScope.launch {
            repository.insert(word)
        }
    }

    class WordViewModelFactory(
        private val repository: WordRepository
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return WordViewModel(repository) as T
        }
    }
}
