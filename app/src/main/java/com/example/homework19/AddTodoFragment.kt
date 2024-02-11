package com.example.homework19

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class AddTodoFragment: Fragment(){
    private lateinit var viewModel:TodoViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.input_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(TodoViewModel::class.java)
        val topicInputField: EditText = view.findViewById(R.id.topicInputField)
        val descriptionInputField: EditText = view.findViewById(R.id.descriptionInputField)
        val addButton: Button = view.findViewById(R.id.addButton)
        addButton.setOnClickListener {
            val name = topicInputField.text.toString()
            val position = descriptionInputField.text.toString()
            viewModel.addTodo(name, position)
            parentFragmentManager.popBackStack()
        }
    }
}