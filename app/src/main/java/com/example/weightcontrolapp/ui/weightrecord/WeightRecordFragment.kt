package com.example.weightcontrolapp.ui.weightrecord

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.weightcontrolapp.R
import com.example.weightcontrolapp.R.layout.weight_record_fragment
import com.google.android.material.snackbar.Snackbar

class WeightRecordFragment : Fragment() {

    private val viewModel: WeightRecordViewModel by activityViewModels()
    private lateinit var weightRecordInput: EditText

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            val weightRecordString = s.toString()
            setWeight(weightRecordString)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(weight_record_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weightRecordInput = view.findViewById(R.id.weight_text_input)
        weightRecordInput.addTextChangedListener(textWatcher)

        view.findViewById<Button>(R.id.weight_record_button).setOnClickListener { v ->
            if (viewModel.userWeightText.value.isNullOrBlank()) {
                Snackbar.make(v, "Record your weight!!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            } else {
                findNavController().navigate(R.id.action_WeightRecordFragment_to_CheckWeightRecordFragment)
            }
        }
    }

    fun setWeight(weightString: String) {
        viewModel.userWeightText.value = weightString
    }
}
