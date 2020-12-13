package com.example.weightcontrolapp.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weightcontrolapp.R
import com.example.weightcontrolapp.data.model.db.WeightData
import kotlinx.android.synthetic.main.history_fragment.*
import kotlinx.android.synthetic.main.weight_record_recycler_view.*
import kotlinx.android.synthetic.main.weight_record_recycler_view.weight_record_recycler_view

class HistoryFragment : Fragment() {

    private val viewModel: HistoryViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.history_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // set up RecyclerView
        recyclerView = recycler_view as RecyclerView

        // load WeightData from db
        val weightDataList = viewModel.loadAllWeightDataList()

        val adapter = HistoryViewAdapter(weightDataList)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        // set adapter
        recyclerView.adapter = adapter
    }
}
