package com.example.hangmangame.database

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.hangmangame.database.dao.ScoreDAO
import com.example.hangmangame.database.entity.DBScore
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class AppDataBaseTest {

    private lateinit var scoreDao: ScoreDAO
    private lateinit var db: AppDataBase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, AppDataBase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        scoreDao = db.scoreDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun basiqueTest() {
        val score: DBScore = DBScore(pseudo = "Quentin", score = 10)
        assertEquals(scoreDao.getAll().isEmpty(), true)
        scoreDao.insertAll(score)

        assertEquals(scoreDao.getAll().size, 1)
        val score2: DBScore = DBScore(pseudo = "Julie", score = 10)
        scoreDao.insertAll(score2)
        assertEquals(scoreDao.getAll().size, 2)

        assertEquals(scoreDao.get("Quentin").get(0), score)
    }

    @Test(expected = SQLiteConstraintException::class)
    fun testInsertTwice() {
        val score: DBScore = DBScore(pseudo = "Quentin", score = 10)
        assertEquals(scoreDao.getAll().isEmpty(), true)
        scoreDao.insertAll(score)
        scoreDao.insertAll(score)

    }
}