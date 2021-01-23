package com.example.weightcontrolapp.ui.history

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weightcontrolapp.R
import com.example.weightcontrolapp.ui.weightrecord.WeightRecordViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.history_fragment.*
import kotlinx.android.synthetic.main.history_graph_fragment.*

class HistoryFragment : Fragment() {

    private val historyViewModel: HistoryViewModel by activityViewModels()

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: HistoryViewAdapter

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

        // set up recycler view
        recyclerView = recycler_view as RecyclerView

        // load WeightData from db
        historyViewModel.loadAllWeightDataList()

        viewAdapter = HistoryViewAdapter(historyViewModel.weightDataList)

        recyclerView.let {
            it.setHasFixedSize(true)
            it.layoutManager = LinearLayoutManager(activity)
            // set adapter
            it.adapter = viewAdapter
            it.adapter?.notifyDataSetChanged()
        }

        fab_to_history_graph.setOnClickListener {
            // create list for instantiating WeightParcelableList
            val list = mutableListOf<String>()
            historyViewModel.weightDataList.forEach {
                list.add(it.weight)
            }

            // use safe args for passing weight strings

            findNavController().navigate(R.id.action_HistoryFragment_to_HistoryGraphFragment)
        }
    }
}

@Parcelize
class WeightParcelableList(private val list: List<String>) : ArrayList<String>(list), Parcelable
