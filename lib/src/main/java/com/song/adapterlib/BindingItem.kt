package com.song.adapterlib

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

abstract class BindingItem<Binding: ViewDataBinding, T> {

    abstract val viewType: Int
    abstract val value: T

    /** Implement  Binding.inflate(inflater,  parent , false) */
    abstract fun createBinding(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): Binding
    abstract fun onBind(binding: Binding)

    open fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<Binding>{
        val binding = createBinding(LayoutInflater.from(parent.context), parent, viewType)
        return BindingViewHolder(binding)
    }

    @Suppress("UNCHECKED_CAST")
    open fun onBindViewHolder(holder: BindingViewHolder<*>, position: Int){
        onBind(holder.binding as Binding)
    }

}