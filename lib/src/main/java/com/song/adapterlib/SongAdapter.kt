package com.song.adapterlib

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class SongAdapter (diffCheck: DiffUtil.ItemCallback<BindingItem<*, *>> = CommonDiffUtil):
        ListAdapter<BindingItem<*, *>, BindingViewHolder<*>>(diffCheck){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<*> {
        val item = currentList.find { it.viewType == viewType }
        return item?.onCreateViewHolder(parent, viewType)
                ?: throw RuntimeException("onCreateViewHolder error, viewType: $viewType")
    }

    override fun onBindViewHolder(holder: BindingViewHolder<*>, position: Int) {
        getItem(position).onBindViewHolder(holder, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType
    }

    private object CommonDiffUtil: DiffUtil.ItemCallback<BindingItem<*, *>>(){
        override fun areItemsTheSame(oldItem: BindingItem<*, *>, newItem: BindingItem<*, *>): Boolean
                = oldItem == newItem

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: BindingItem<*, *>, newItem: BindingItem<*, *>): Boolean
                = oldItem.value == newItem.value
    }
}