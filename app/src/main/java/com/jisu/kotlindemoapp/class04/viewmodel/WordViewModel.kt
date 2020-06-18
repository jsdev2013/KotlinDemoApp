package com.jisu.kotlindemoapp.class04.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.jisu.kotlindemoapp.class04.entity.Word
import com.jisu.kotlindemoapp.class04.repository.WordRepository


class WordViewModel : AndroidViewModel {
    private val repository: WordRepository
    private val allWords: LiveData<List<Word>>

    constructor(app: Application) : super(app) {
        repository = WordRepository(app)
        allWords = repository.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>> = allWords
    fun insert(word: Word) {
        repository.insert(word)
    }
}