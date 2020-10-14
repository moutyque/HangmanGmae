package com.example.hangmangame.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hangmangame.model.Score

@Entity(tableName = "scores")
data class DBScore(
    @PrimaryKey
    var pseudo: String = "",
    var score: Int = 0
) {


}

//Conversion method to go from DB model to kotlin model
fun List<DBScore>.asDomainModel(): List<Score> {
    return map {
        Score(
            pseudo = it.pseudo,
            score = it.score
        )
    }

}