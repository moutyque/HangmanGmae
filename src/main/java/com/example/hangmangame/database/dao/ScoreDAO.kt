package com.example.hangmangame.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.hangmangame.database.entity.Score

@Dao
interface ScoreDAO {
    @Query("SELECT * FROM scores")
    fun getAll(): List<Score>

    @Query("SELECT * FROM scores WHERE pseudo IN (:psuedo)")
    fun get(psuedo: String): List<Score>


    @Insert
    fun insertAll(vararg scors: Score)

    @Delete
    fun delete(score: Score)

}