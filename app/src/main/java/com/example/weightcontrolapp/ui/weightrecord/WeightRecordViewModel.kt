package com.example.weightcontrolapp.ui.weightrecord

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weightcontrolapp.MainActivity
import com.example.weightcontrolapp.data.model.db.WeightData

class WeightRecordViewModel : ViewModel() {
    var userWeightText = MutableLiveData<String>()
    // Instantiate WeightDataDao
    private val dao = MainActivity.db.weightDataDao()

    // This method is called in WeightRecordFragment
    fun loadAllWeightDataList() {
        dao.loadAllWeightData()
    }

    // This method is called in WeightRecordFragment
    fun loadWeightData(weightData: WeightData) {
        dao.insertWeightData(weightData)
    }

}
