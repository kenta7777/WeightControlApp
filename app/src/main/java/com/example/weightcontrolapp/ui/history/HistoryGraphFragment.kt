package com.example.weightcontrolapp.ui.history

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weightcontrolapp.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.history_graph_fragment.*

class HistoryGraphFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        createLineGraph()

        return inflater.inflate(R.layout.history_graph_fragment, container, false)
    }

    private fun createLineGraph() {
        // create data for showing graph
        val n1 = 1f
        val n2 = 2f

        val xAxisDataList = listOf<Float>(n1, n2)
        val yAxisDataList = xAxisDataList.map { it*it }

        // create Entry
        val entryList = mutableListOf<Entry>()

        xAxisDataList.forEachIndexed { index, _ ->
            entryList.add(
                Entry(xAxisDataList[index], yAxisDataList[index])
            )
        }

        // DataSet holds entry
        val lineDataSets = mutableListOf<ILineDataSet>()
        val lineDataSet = LineDataSet(entryList, "square")
        lineDataSets.add(lineDataSet)

        // Data holds DataSet
        val lineData = LineData(lineDataSets)

        // Chart holds Data
        val lineChart = view?.findViewById<LineChart>(R.id.weight_data_line_chart)
        lineChart?.data = lineData

        lineChart?.xAxis?.apply {
            isEnabled = true
            textColor = Color.BLACK
        }

        lineChart?.invalidate()
    }
}
