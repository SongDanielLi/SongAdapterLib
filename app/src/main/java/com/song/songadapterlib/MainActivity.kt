package com.song.songadapterlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.song.adapterlib.SongAdapter
import com.song.adapterlib.BindingItem
import com.song.songadapterlib.recycler.CardRow
import com.song.songadapterlib.recycler.HeaderRow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = SongAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val list = mutableListOf<BindingItem<*,*>>()
        list.add(HeaderRow(){
            Toast.makeText(this, "Click", Toast.LENGTH_LONG).show()
        })
        for(i in 1..10){
            list.add(CardRow("Card: $i"))
        }
        adapter.submitList(list.toList())
    }
}