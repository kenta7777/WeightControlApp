package com.example.weightcontrolapp.ui.history

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weightcontrolapp.R
import kotlinx.android.synthetic.main.weight_record_item.view.*

class HistoryViewHolder(weightRecordItemView: View) : RecyclerView.ViewHolder(weightRecordItemView) {
    val idView: TextView = itemView.findViewById(R.id.id)
    val dateView: TextView = itemView.findViewById(R.id.date)
    val weightView: TextView = itemView.findViewById(R.id.weight)
}
