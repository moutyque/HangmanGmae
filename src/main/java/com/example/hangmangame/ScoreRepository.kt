package com.example.hangmangame

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.hangmangame.database.AppDataBase
import com.example.hangmangame.database.dao.ScoreDAO
import com.example.hangmangame.database.entity.DBScore
import com.example.hangmangame.database.entity.asDomainModel
import com.example.hangmangame.model.Score
import kotlinx.coroutines.*
import java.util.concurrent.Executor

class ScoreRepository(private val database: AppDataBase) {

    /**
     * This is the job for all coroutines started by this ViewModel.
     * Cancelling this job will cancel all coroutines started by this ViewModel.
     */
    private val job = SupervisorJob()

    /**
     * This is the main scope for all coroutines launched by MainViewModel.
     * Since we pass viewModelJob, you can cancel all coroutines
     * launched by uiScope by calling viewModelJob.cancel()
     */
    private val ioScope = CoroutineScope(Dispatchers.IO + job)


    val scores: LiveData<List<Score>> =
        getScore()


    init {
        printScores()
    }

    fun printScores() {
        Log.i("ScoreRepository", "scores : " + getScore().value.toString())
    }


    fun getScore(): LiveData<List<Score>> {
        return Transformations.map(database.scoreDao.getAll()) {
            it.asDomainModel()
        }
    }

    suspend fun insert(scores: List<Score>) {
        withContext(Dispatchers.IO) {
            var dbScores: List<DBScore>
            dbScores = scores.map { score -> DBScore(pseudo = score.pseudo, score = score.score) }
            database.scoreDao.insertAll(dbScores)
        }

    }

}