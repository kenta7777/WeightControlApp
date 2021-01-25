package com.example.weightcontrolapp.common

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class WeightParcelableList(private val list: List<String>) : ArrayList<String>(list), Parcelable
