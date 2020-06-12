package com.example.universallistadapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.universallistadapter.datasource.Repository
import com.example.universallistadapter.entitys.RecyclerItem

class MainViewModel : ViewModel() {

    private val _recyclerItems = MutableLiveData<List<RecyclerItem>>()
    val recyclerItems: LiveData<List<RecyclerItem>> = _recyclerItems
    private val repository =
        Repository()

    init {
        _recyclerItems.value = repository.loadFirstList()
            .map { UserItemViewModel(it)}
            .map { it.toRecyclerItem() }
    }


    fun loadFirstList() {
        val recItems = repository.loadFirstList()
            .map { UserItemViewModel(it)}
            .map { it.toRecyclerItem() }
        _recyclerItems.postValue(recItems)
    }

    fun loadSecondList() {
        val recItems = repository.loadSecondList()
            .map { UserItemViewModel(it)}
            .map { it.toRecyclerItem() }
        _recyclerItems.postValue(recItems)
    }
}
