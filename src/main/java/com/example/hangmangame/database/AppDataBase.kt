package com.example.hangmangame.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hangmangame.database.dao.ScoreDAO
import com.example.hangmangame.database.entity.DBScore


//Define the class as a database
@Database(entities = [DBScore::class], version = 1, exportSchema = true)
//Extends RoomData base
abstract class AppDataBase : RoomDatabase() {
    //Define a DAO (can be multiple)
    abstract val scoreDao: ScoreDAO

    companion object {

        //Declare an instance of the DB to make it a singleton
        //Volatile is use to make it instantly visible by all thread
        @Volatile
        private lateinit var INSTANCE: AppDataBase
        fun getInstance(context: Context): AppDataBase {
            synchronized(AppDataBase::class.java) {
                if (!::INSTANCE.isInitialized) {

                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java,
                        "app_database"
                    ).build()

                    //.createFromAsset("database/scores.db")
                }
                return INSTANCE;
            }


        }

    }

}
