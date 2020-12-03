package com.song.adapterlib

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BindingViewHolder<Binding: ViewDataBinding>(val binding: Binding): RecyclerView.ViewHolder(binding.root)