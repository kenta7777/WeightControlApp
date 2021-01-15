package com.example.weightcontrolapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weightcontrolapp.data.model.db.WeightData

@Dao
interface WeightDataDao {
    // load all WeightData in AppDatabase
    @Query("SELECT * FROM weight_data")
    fun loadAllWeightData(): List<WeightData>

    // find a WeightData by id
    @Query("SELECT * FROM weight_data WHERE id = :id")
    fun findWeightDataById(id: Int): WeightData

    // insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeightData(weightData: WeightData)
}
