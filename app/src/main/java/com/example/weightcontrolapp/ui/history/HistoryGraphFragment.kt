package com.example.weightcontrolapp.ui.history

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.weightcontrolapp.R
import com.example.weightcontrolapp.common.WeightParcelableList
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.history_graph_fragment.*

class HistoryGraphFragment : Fragment() {

    private val args: HistoryGraphFragmentArgs by navArgs()

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

        createLineGraph(args.weightParcelableList)
    }

    private fun createLineGraph(list: WeightParcelableList) {
        // create the data for x axis
        val xAxisDataList = mutableListOf<Float>()
        val origin = 1

        listOf(origin..list.size).forEach { intRange ->
            intRange.forEach {
                xAxisDataList.add(it.toFloat())
            }
        }

        // create the data for y axis
        val yAxisDataList = list.map {
            it.toFloat()
        }

        // create `entry`
        // entry: the data per one drawing point
        val entryList = mutableListOf<Entry>()
        xAxisDataList.forEachIndexed { index, _ ->
            entryList.add(
                Entry(xAxisDataList[index], yAxisDataList[index])
            )
        }

        // set entry list to `dataset`
        // dataset: the set of entry
        val lineDataSets = mutableListOf<ILineDataSet>()
        val lineDataSet = LineDataSet(entryList, "square")
        lineDataSets.add(lineDataSet)

        // set dataset to `data`
        // data: overall data of graph
        val lineData = LineData(lineDataSets)

        // set data to `chart`
        // chart: data and UI format of graph
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
