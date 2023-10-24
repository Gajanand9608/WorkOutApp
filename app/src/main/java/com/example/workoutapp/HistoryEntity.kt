package com.example.workoutapp

import androidx.room.*
import androidx.room.PrimaryKey

@Entity(tableName = "history-table")
data class HistoryEntity(
    @PrimaryKey
    val data : String


)
