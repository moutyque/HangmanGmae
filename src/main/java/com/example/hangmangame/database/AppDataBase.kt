package com.example.hangmangame.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hangmangame.database.dao.ScoreDAO
import com.example.hangmangame.database.entity.Score

@Database(entities = arrayOf(Score::class), version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun scoreDao(): ScoreDAO
}
//Must go to the repository class
//val db = Room.databaseBuilder(
//    applicationContext,
//    AppDatabase::class.java, "scores-database"
//).build()