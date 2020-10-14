package com.example.hangmangame.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.hangmangame.database.entity.DBScore

//Always return LiveData to hold an observer on the data

@Dao
interface ScoreDAO {
    @Query("SELECT * FROM scores")
    fun getAll(): LiveData<List<DBScore>>

    @Query("SELECT * FROM scores WHERE pseudo IN (:pseudo)")
    fun get(pseudo: String): LiveData<List<DBScore>>

    @Insert
    fun insertAll(scores: List<DBScore>)

    @Delete
    fun delete(score: DBScore)

}