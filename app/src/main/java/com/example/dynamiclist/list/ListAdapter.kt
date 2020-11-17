package com.example.dynamiclist.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamiclist.R
import java.util.ArrayList

class ListAdapter(private var context: Context, private var itemList: ArrayList<ItemModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_adapter, parent, false)

        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val listViewHolder: ListViewHolder = holder as ListViewHolder
        listViewHolder.onBind(itemList)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val team: TextView = itemView.findViewById(R.id.team)

        fun onBind(itemModel: ArrayList<ItemModel>) {
            name.text = itemModel[position].itemName
            team.text = itemModel[position].itemTeam
        }
    }
}