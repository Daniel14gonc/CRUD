package com.uvg.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var adapter = Adapter({
        clickListener -> showItemClick(clickListener)
    },
    {
        longClickListener -> changeItemClick(longClickListener)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items: MutableList<String> = mutableListOf()
        items.add("Prueba1")
        items.add("Prueba2")
        items.add("Prueba3")
        items.add("Prueba4")

        add.setOnClickListener {
            items.add("Prueba" + (items.size+1))
            adapter.setItems(items)
        }


        adapter.setItems(items)

        lista.layoutManager = LinearLayoutManager(this) //Existe linear, grid, etc
        lista.adapter = adapter

    }

    fun showItemClick(postion:Int){
        adapter.deleteItem(postion)
    }

    fun changeItemClick(position:Int){
        adapter.changeData(position)
    }
}