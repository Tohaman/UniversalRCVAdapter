package com.example.universallistadapter

import android.util.Log
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
        loadFirstList()
    }

    fun loadFirstList() {
        val recItems = repository.loadFirstList()
            .map { UserItemViewModel(it)}
            .onEach { it.clickHandler = onClickByUser()
            }
            .map { it.toRecyclerItem() }
        _recyclerItems.postValue(recItems)
    }

    private val clickCallBack = onClickByUser()

    private fun onClickByUser(): OnClickByUser {
        return object : OnClickByUser {
            override fun onClick(id: Int) {
                Log.d("TAG", "Таки нажали на элемент $id :)")
            }
        }
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
