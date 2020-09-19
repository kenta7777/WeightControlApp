package com.example.weightcontrolapp.ui.weightrecord

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.weightcontrolapp.R

class CheckWeightRecordFragment : Fragment() {

    private val viewModel: WeightRecordViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.check_weight_record_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weight = viewModel.userWeightText.value.toString()
        val recordWeightMessage: String = getString(R.string.record_weight_message, weight)

        val recordedWeightTextView: TextView = view.findViewById(R.id.recordedWeightTextView)
        recordedWeightTextView.text = recordWeightMessage

        view.findViewById<Button>(R.id.backToWeightRecordScreenButton).setOnClickListener {
            clearUserInput()
            findNavController().navigate(R.id.action_CheckWeightRecordFragment_to_WeightRecordFragment)
        }
    }

    private fun clearUserInput() {
        viewModel.userWeightText.value = null
    }
}