package com.example.dynamiclist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.Fragment
import java.util.ArrayList

class ListFragment : Fragment() {
    private lateinit var addButton: Button
    private lateinit var listLayout: LinearLayout
    private lateinit var nameEditText: EditText
    private lateinit var spinner: AppCompatSpinner
    private lateinit var removeImage: ImageView
    private lateinit var teamList: ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addButton = view.findViewById(R.id.addItem)
        listLayout = view.findViewById(R.id.listLayout)
        fillList()
        addButton.setOnClickListener {
            addView()
        }
    }

    private fun addView() {
        val itemView = layoutInflater.inflate(R.layout.add_row_layout, null, false)
        nameEditText = itemView.findViewById(R.id.itemName)
        spinner = itemView.findViewById(R.id.spinner)
        removeImage = itemView.findViewById(R.id.remove)

        val arrayAdapter =
            context?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, teamList) }
        spinner.adapter = arrayAdapter

        removeImage.setOnClickListener {
            removeView(itemView)
        }

        listLayout.addView(itemView)
    }

    private fun removeView(view: View) {
        listLayout.removeView(view)
    }

    private fun fillList() {
        teamList = ArrayList()
        teamList.add("Choose")
        teamList.add("Iran")
        teamList.add("Japan")
        teamList.add("India")
        teamList.add("Australia")

    }
}