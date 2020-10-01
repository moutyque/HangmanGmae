package com.example.hangmangame.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName  ="scores")
data class Score(
    @PrimaryKey
    var pseudo: String = "",
    var score : Int = 0
) {
}