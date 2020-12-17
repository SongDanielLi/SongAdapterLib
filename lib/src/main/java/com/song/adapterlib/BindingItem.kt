package com.song.adapterlib

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

abstract class BindingItem<Binding: ViewDataBinding, T> {

    abstract val viewType: Int
    abstract val data: T

    /** Implement  Binding.inflate(inflater,  parent , false) */
    abstract fun createBinding(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): Binding
    abstract fun onBind(binding: Binding, position: Int)

    /**  override to set click listener*/
    open fun onClickListener(view: View, position: Int) {}
    open fun onLongClickListener(view: View, position: Int){}


    open fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<Binding>{
        val binding = createBinding(LayoutInflater.from(parent.context), parent, viewType)
        binding.executePendingBindings()
        return BindingViewHolder(binding)
    }

    @Suppress("UNCHECKED_CAST")
    open fun onBindViewHolder(holder: BindingViewHolder<*>, position: Int){
        onBind(holder.binding as Binding, position)
        holder.binding.root.apply {
            setOnClickListener { view-> onClickListener(view, position) }
            setOnLongClickListener {view ->
                onLongClickListener(view, position)
                true
            }
        }
    }

}