package com.monapk.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_course_data_cell.view.*


class RecyclerViewAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    val items = mutableListOf<Data>()

    fun addAll(items: List<Data>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_course_data_cell, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.itemIV.setImageResource(item.imageResource)
        holder.titleTV.text = item.title
        holder.contentTV.text = item.content
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val itemIV: ImageView = v.findViewById(R.id.itemIV)
        val titleTV: TextView = v.findViewById(R.id.titleTV)
        val contentTV: TextView = v.findViewById(R.id.contentTV)
    }
}