package com.example.hangmangame.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hangmangame.ScoreRepository
import com.example.hangmangame.database.AppDataBase

class ScoreViewModel(application: Application) : AndroidViewModel(application) {

    private val scoreRepository = ScoreRepository(AppDataBase.getInstance(application))

    val score = scoreRepository.getScore()


    /**
     * Factory for constructing ViewModelProvider with parameter
     */
    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ScoreViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}