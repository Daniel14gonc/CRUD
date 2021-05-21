package com.uvg.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista.view.*

class ItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item:String, click: (Int) -> Unit) = with(itemView){
        txtTitulo.text = item

        setOnClickListener{
            click(adapterPosition)
        }
    }
}