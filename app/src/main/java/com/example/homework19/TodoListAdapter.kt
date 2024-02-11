package com.example.homework19

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter (var items:List<Todo> = emptyList()): RecyclerView.Adapter<TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val listItemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return TodoViewHolder(listItemView)
    }
    fun updateItems(itemsToUpdate:List<Todo>){
        items = itemsToUpdate
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.topic.text = items[position].topic
        holder.description.text = items[position].description
    }
}

class TodoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val topic: TextView = itemView.findViewById(R.id.topic)
    val description: TextView = itemView.findViewById(R.id.description)
}