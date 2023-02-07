package com.impacta.wordlist

import androidx.annotation.WorkerThread
import com.impacta.wordlist.model.Word
import com.impacta.wordlist.model.WordDao

class WordRepository(private val wordDao: WordDao) {

    val allWords = wordDao.getAlphabetizedWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}