package com.example.weightcontrolapp.ui.history

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weightcontrolapp.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.history_fragment.*
import kotlinx.android.synthetic.main.history_graph_fragment.*

class HistoryGraphFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.history_graph_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab_to_history.setOnClickListener {
            findNavController().navigate(R.id.action_HistoryGraphFragment_to_HistoryFragment)
        }

        createLineGraph()
    }

    private fun createLineGraph() {
        // create data for showing graph
        val n1 = 1f
        val n2 = 2f

        val xAxisDataList = listOf<Float>(n1, n2)
        val yAxisDataList = xAxisDataList.map { it*it }

        // create `Entry`
        val entryList = mutableListOf<Entry>()

        xAxisDataList.forEachIndexed { index, _ ->
            entryList.add(
                Entry(xAxisDataList[index], yAxisDataList[index])
            )
        }

        // set Entry to `dataset`
        val lineDataSets = mutableListOf<ILineDataSet>()
        val lineDataSet = LineDataSet(entryList, "square")
        lineDataSets.add(lineDataSet)

        // set dataset to `data`
        val lineData = LineData(lineDataSets)

        // set data to `chart`
        val lineChart = view?.findViewById<LineChart>(R.id.weight_data_line_chart)
        lineChart?.data = lineData

        // specify line chart format
        lineChart?.xAxis?.apply {
            isEnabled = true
            textColor = Color.BLACK
        }

        // update chart
        lineChart?.invalidate()
    }
}
