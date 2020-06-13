package com.example.universallistadapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.universallistadapter.datasource.Repository
import com.example.universallistadapter.entitys.RecyclerItem
import com.example.universallistadapter.entitys.User

class MainViewModel : ViewModel() {

    private val _recyclerItems = MutableLiveData<List<RecyclerItem>>()
    val recyclerItems: LiveData<List<RecyclerItem>> = _recyclerItems
    private val repository =
        Repository()

    init {
        loadFirstList()
    }


    fun loadFirstList() {
        val recItems = repository.loadFirstList()
            .map { UserItemViewModel(it)}
            .map { it.toRecyclerItem() }
        _recyclerItems.postValue(recItems)
    }

    fun loadSecondList() {
        var users = getUserList()
        users = users.map { it.firstName = it.lastName
        it }
        val recItems = users
            .map { UserItemViewModel(it) }
            .map { it.toRecyclerItem() }
        _recyclerItems.postValue(recItems)
    }

    private fun getUserList() = recyclerItems.value.orEmpty()
        .map { it.data }
        .filterIsInstance<UserItemViewModel>()
        .map { it.user }
}
