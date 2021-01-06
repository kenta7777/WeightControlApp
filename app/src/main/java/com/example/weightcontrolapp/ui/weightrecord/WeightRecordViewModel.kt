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

    fun insertWeightData(weightData: WeightData) {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.Default) {
                Timber.d("insert weightData: $weightData")
                dao.insertWeightData(weightData)
            }
        }
    }
}
