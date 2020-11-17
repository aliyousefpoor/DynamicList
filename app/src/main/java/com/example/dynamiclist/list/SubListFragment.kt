package com.example.dynamiclist.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamiclist.R
import java.util.ArrayList

class SubListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemList: ArrayList<ItemModel>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sub_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemList = arguments?.getParcelableArrayList<ItemModel>("list") as ArrayList<ItemModel>

        recyclerView = view.findViewById(R.id.recyclerView)

        val listAdapter = ListAdapter(requireContext(), itemList)
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = listAdapter
        recyclerView.layoutManager = layoutManager
    }
}