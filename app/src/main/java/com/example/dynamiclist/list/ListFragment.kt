package com.example.dynamiclist.list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.dynamiclist.R
import java.util.ArrayList

class ListFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var addButton: Button
    private lateinit var submitList: Button
    private lateinit var listLayout: LinearLayout
    private lateinit var nameEditText: EditText
    private lateinit var spinner: AppCompatSpinner
    private lateinit var removeImage: ImageView
    private lateinit var teamList: ArrayList<String>
    private lateinit var itemList: ArrayList<ItemModel>

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
        submitList = view.findViewById(R.id.submitListButton)
        listLayout = view.findViewById(R.id.listLayout)
        navController = Navigation.findNavController(view)
        fillList()
        addButton.setOnClickListener {
            addView()
        }

        submitList.setOnClickListener {
            if (checkIfValid()) {
                val bundle = Bundle()
                bundle.putParcelableArrayList("list", itemList)
                navController.navigate(R.id.action_listFragment2_to_subListFragment, bundle)
            }
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

    private fun checkIfValid(): Boolean {
        var itemModel: ItemModel
        itemList = ArrayList()
        itemList.clear()
        var result = true
        var i = 0

        while (i < listLayout.childCount) {
            i++
            if (nameEditText.text.isNotEmpty() && spinner.selectedItemPosition != 0) {
                itemModel = ItemModel(
                    nameEditText.text.toString(),
                    teamList.get(spinner.selectedItemPosition)
                )
            } else {
                result = false
                break
            }

            itemList.add(itemModel)

        }

        if (itemList.size == 0) {
            result = false
            Toast.makeText(requireContext(), "Add Cricketers First!", Toast.LENGTH_SHORT).show()
        } else if (!result) {
            Toast.makeText(requireContext(), "Enter All Details Correctly!", Toast.LENGTH_SHORT)
                .show()
        }

        return result
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