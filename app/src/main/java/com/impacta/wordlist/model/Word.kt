package com.impacta.wordlist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("word_table")
data class Word(
    @PrimaryKey
    @ColumnInfo("word")
    val word: String,
)
