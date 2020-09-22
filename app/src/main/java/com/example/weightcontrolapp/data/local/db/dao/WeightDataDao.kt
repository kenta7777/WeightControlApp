package com.example.weightcontrolapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weightcontrolapp.data.model.db.WeightData

@Dao
interface WeightDataDao {
    // load all weight data in database
    @Query("SELECT * FROM weight_data")
    fun loadAllWeightData(): List<WeightData>

    // insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeightData(weightData: WeightData)

    //TODO: Delete
}
