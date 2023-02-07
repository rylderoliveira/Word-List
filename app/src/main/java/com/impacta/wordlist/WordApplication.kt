package com.impacta.wordlist

import android.app.Application

class WordApplication : Application() {

    lateinit var repository: WordRepository

    override fun onCreate() {
        super.onCreate()
        val database = WordRoomDatabase.getDatabase(this)
        repository = WordRepository(database.wordDao())
    }
}