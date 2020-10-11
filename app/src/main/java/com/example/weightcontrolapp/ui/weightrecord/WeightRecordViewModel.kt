package com.example.weightcontrolapp.ui.weightrecord

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weightcontrolapp.MainActivity
import com.example.weightcontrolapp.data.model.db.WeightData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class WeightRecordViewModel : ViewModel() {
    var userWeightText = MutableLiveData<String>()

    private val dao = MainActivity.db.weightDataDao()

    // use when implement history screen
    fun loadAllWeightDataList(): List<WeightData> {
        var weightDataList = listOf<WeightData>()
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.Default) {
                weightDataList = dao.loadAllWeightData()
            }
        }
        return weightDataList
    }

    // use when implement history screen
    fun findWeightDataById(id: Int): WeightData {
        lateinit var weightData: WeightData
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.Default) {
                weightData = dao.findWeightDataById(id)
            }
        }
        return weightData
    }

    fun insertWeightData(weightData: WeightData) {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.Default) {
                Timber.d("insert weightData: $weightData")
                dao.insertWeightData(weightData)
            }
        }
    }

}
