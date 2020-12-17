package com.song.songadapterlib.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.song.adapterlib.BindingItem
import com.song.songadapterlib.R
import com.song.songadapterlib.databinding.CardViewBinding

class CardRow(override val data: String): BindingItem<CardViewBinding, String>() {
    override val viewType: Int
        get() = R.layout.card_view

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): CardViewBinding {
        return CardViewBinding.inflate(inflater, parent, false)
    }

    override fun onBind(binding: CardViewBinding, position: Int) {
        binding.txtCard.text = data
    }

    override fun onClickListener(view: View, position: Int) {
        Toast.makeText(view.context, "Click: $position", Toast.LENGTH_LONG).show()
    }

    override fun onLongClickListener(view: View, position: Int) {
        Toast.makeText(view.context, "Long Click: $position", Toast.LENGTH_LONG).show()
    }
}