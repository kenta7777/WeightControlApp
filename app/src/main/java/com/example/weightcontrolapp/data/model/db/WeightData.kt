package com.example.weightcontrolapp.data.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "weight_data")
data class WeightData (
    @PrimaryKey
    val data: Date,
    val weight: String
)
