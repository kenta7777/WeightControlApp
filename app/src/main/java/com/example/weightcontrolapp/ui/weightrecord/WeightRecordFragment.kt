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
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.weightcontrolapp.R
import com.example.weightcontrolapp.R.layout.weight_record_fragment
import kotlinx.android.synthetic.main.weight_record_fragment.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
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

            if (weightRecordString.isEmpty()) {
                //TODO Error Handling
            }
        }
    }

    private var root: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //viewModel.userWeightText.value = weight_text_input.text.toString()
//        val binding = DataBindingUtil.setContentView(this, R.layout.weight_record_fragment)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val editText = EditText(requireContext())

        return inflater.inflate(weight_record_fragment, container, false)


        //val weightEditText = v?.findViewById<EditText>(R.id.weight_text_input)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.weight_record_button).setOnClickListener {
            findNavController().navigate(R.id.action_WeightRecordFragment_to_CheckWeightRecordFragment)
        }
    }

    //TODO: Show the value in CheckWeightRecordFragment
    //TODO: Deal with abnormal value(e.g blank space) in weight record EditText
}