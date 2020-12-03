package com.song.adapterlib

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

abstract class BindingItem<Binding: ViewDataBinding, T> {

    abstract val viewType: Int
    abstract val value: T

    abstract fun createBinding(parent: ViewGroup, viewType: Int): Binding
    abstract fun onBind(binding: Binding)

    open fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<Binding>{
        val binding = createBinding(parent, viewType)
        return BindingViewHolder(binding)
    }

    @Suppress("UNCHECKED_CAST")
    open fun onBindViewHolder(holder: BindingViewHolder<*>, position: Int){
        onBind(holder.binding as Binding)
    }

}