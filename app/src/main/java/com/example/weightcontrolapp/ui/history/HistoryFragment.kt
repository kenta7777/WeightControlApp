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
import kotlinx.android.synthetic.main.history_fragment.*

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
        viewModel.loadAllWeightDataList()

        val viewAdapter = HistoryViewAdapter(viewModel.weightDataList)

        recyclerView.let {
            it.setHasFixedSize(true)
            it.layoutManager = LinearLayoutManager(activity)
            // set adapter
            it.adapter = viewAdapter
            it.adapter?.notifyDataSetChanged()
        }
    }
}
