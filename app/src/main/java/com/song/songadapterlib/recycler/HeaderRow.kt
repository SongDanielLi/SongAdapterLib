package com.song.songadapterlib.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.song.adapterlib.BindingItem
import com.song.songadapterlib.R
import com.song.songadapterlib.databinding.HeaderLayoutBinding

class HeaderRow(val listener: (View?) -> Unit): BindingItem<HeaderLayoutBinding, Int>() {

    override val viewType: Int
        get() = R.layout.header_layout
    override val value: Int
        get() = R.drawable.golf

    override fun createBinding(parent: ViewGroup, viewType: Int): HeaderLayoutBinding {
        return HeaderLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun onBind(binding: HeaderLayoutBinding) {
        binding.fab.setOnClickListener{ listener(it) }
    }
}