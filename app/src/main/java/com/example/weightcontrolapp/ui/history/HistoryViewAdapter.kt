package com.example.weightcontrolapp.ui.history

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.weightcontrolapp.R
import com.example.weightcontrolapp.data.model.db.WeightData
import timber.log.Timber

class HistoryViewAdapter(private val list: List<WeightData>) :
    RecyclerView.Adapter<HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        Timber.d("onCreateViewHolder")
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.weight_record_item, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        Timber.d("onBindViewHolder")
        holder.idView.text = list[position].id.toString()
        holder.dateView.text = list[position].date.toString()
        holder.weightView.text = list[position].weight
    }

    override fun getItemCount(): Int {
        Timber.d("getItemCount")
        return list.size
    }
}
