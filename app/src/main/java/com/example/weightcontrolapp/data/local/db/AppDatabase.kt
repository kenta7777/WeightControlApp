package com.example.weightcontrolapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weightcontrolapp.data.DateConverters
import com.example.weightcontrolapp.data.local.db.dao.WeightDataDao
import com.example.weightcontrolapp.data.model.db.WeightData

// With @Database, this class connects SQLite directly.
// Entity class: DB table
@Database(entities = [WeightData::class], version = 1)
@TypeConverters(DateConverters::class)
abstract class AppDatabase : RoomDatabase() {
    //TODO: implement abstract method of Dao interface defined in @Dao
    abstract fun weightDataDao(): WeightDataDao
}
