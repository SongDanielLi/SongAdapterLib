package com.song.songadapterlib.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import com.song.adapterlib.BindingItem
import com.song.songadapterlib.R
import com.song.songadapterlib.databinding.CardViewBinding

class CardRow(override val value: String): BindingItem<CardViewBinding, String>() {
    override val viewType: Int
        get() = R.layout.card_view

    override fun createBinding(parent: ViewGroup, viewType: Int): CardViewBinding {
        return CardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun onBind(binding: CardViewBinding) {
        binding.txtCard.text = value
    }
}