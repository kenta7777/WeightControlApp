package com.example.weightcontrolapp.ui.history

import androidx.lifecycle.ViewModel
import com.example.weightcontrolapp.MainActivity
import com.example.weightcontrolapp.data.model.db.WeightData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryViewModel : ViewModel() {

    private val dao = MainActivity.db.weightDataDao()

    var weightDataList = listOf<WeightData>()

    fun loadAllWeightDataList() {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.Default) {
                weightDataList = dao.loadAllWeightData()
            }
        }
    }
}
