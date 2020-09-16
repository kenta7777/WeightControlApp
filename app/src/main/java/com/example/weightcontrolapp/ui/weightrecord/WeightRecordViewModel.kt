package com.example.weightcontrolapp.ui.weightrecord

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeightRecordViewModel : ViewModel() {
    var userWeightText = MutableLiveData<String>()
}