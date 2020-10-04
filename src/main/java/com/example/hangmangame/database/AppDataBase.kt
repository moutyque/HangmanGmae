package com.example.hangmangame.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.hangmangame.database.dao.ScoreDAO
import com.example.hangmangame.database.entity.Score

//Define the class as a database
@Database(entities = [Score::class], version = 1, exportSchema = false)
//Extends RoomData base
abstract class AppDataBase : RoomDatabase() {
    //Define a DAO (can be multiple)
    abstract fun scoreDao(): ScoreDAO

    companion object {

        //Declare an instance of the DB to make it a singleton
        //Volatile is use to make it instantly visible by all thread
        @Volatile
        var INSTANCE: AppDataBase? = null


        fun getInstance(context: Context): AppDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java,
                        "app_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance;
            }
        }

    }

}
