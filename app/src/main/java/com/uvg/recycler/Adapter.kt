package com.uvg.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val clickListener: (Int) -> Unit): RecyclerView.Adapter<ItemsViewHolder>() {
    private var items: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ItemsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, clickListener)
    }

    fun setItems(newItems: MutableList<String>){
        this.items = newItems
        notifyDataSetChanged()
    }

    fun getItem(position:Int): String{
        return items[position]
    }

    fun deleteItem(position: Int){
        items.removeAt(position)
        notifyDataSetChanged()
    }

}