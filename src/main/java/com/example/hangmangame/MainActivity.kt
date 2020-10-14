package com.example.hangmangame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hangmangame.database.AppDataBase
import com.example.hangmangame.model.Score
import com.example.hangmangmae.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        val p1: Score = Score(pseudo = "player1", score = 0)
        val p2: Score = Score(pseudo = "player2", score = 5)
        val p3: Score = Score(pseudo = "player3", score = 10)


        super.onCreate(savedInstanceState)
//        var repo = ScoreRepository(AppDataBase.getInstance(application))
//        repo.insert(listOf(p1, p2, p3))
        setContentView(R.layout.activity_main)
    }
}