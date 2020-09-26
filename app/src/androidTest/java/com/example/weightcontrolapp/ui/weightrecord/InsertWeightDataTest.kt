package com.example.weightcontrolapp.ui.weightrecord

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.weightcontrolapp.data.local.db.AppDatabase
import com.example.weightcontrolapp.data.local.db.dao.WeightDataDao
import com.example.weightcontrolapp.data.model.db.WeightData
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.*

@RunWith(AndroidJUnit4::class)
class InsertWeightDataTest {
    private lateinit var db: AppDatabase
    private lateinit var dao: WeightDataDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        dao = db.weightDataDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun testInsertWeightData() = runBlocking {
        val dummyId = 0
        val dummyDate = Date()
        val dummyWeight = "0"
        val weightData = WeightData(dummyId, dummyDate, dummyWeight)

        // insert dummy
        dao.insertWeightData(weightData)

        // findbyWeightId
        // id generated automatically was 1, so specifies parameter of findWeightDataById as 1
        val expectedWeightData = dao.findWeightDataById(1)

        assertEquals(expectedWeightData.weight, dummyWeight)
    }
}