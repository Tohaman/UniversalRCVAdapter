package com.example.universallistadapter.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.universallistadapter.entitys.RecyclerItem


@BindingAdapter("items")
fun setRecyclerViewItems(recyclerView: RecyclerView, items: List<RecyclerItem>?) {
    var adapter = (recyclerView.adapter as? DataBindingRecyclerAdapter)
    if (adapter == null) {
        adapter = DataBindingRecyclerAdapter()
        recyclerView.adapter = adapter
    }

    adapter.submitList(
        items.orEmpty()
    )
}