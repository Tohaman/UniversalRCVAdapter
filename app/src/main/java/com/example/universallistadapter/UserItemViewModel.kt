package com.example.universallistadapter

import com.example.universallistadapter.adapter.RecyclerItemComparator
import com.example.universallistadapter.entitys.RecyclerItem
import com.example.universallistadapter.entitys.User

class UserItemViewModel(val user: User): RecyclerItemComparator, OnClickByUser {

    var clickHandler: OnClickByUser? = null

    override fun isSameItem(other: Any): Boolean {
        //is same object?
        if (this === other) return true
        //is same javaClass?
        if (javaClass != other.javaClass) return false
        //if javaClass is same
        other as UserItemViewModel
        return this.user.id == other.user.id
    }

    //only if isSameItem == true, check content
    override fun isSameContent(other: Any): Boolean {
        other as UserItemViewModel
        return this.user == other.user
    }

    override fun onClick() = clickHandler?.invoke()     //wtf?

    fun onCheckedChange(value: Boolean) {
        //При смене значения, меням его в адаптере
    }

    fun toRecyclerItem() = RecyclerItem(
            data = this,
            layoutId = R.layout.item_user,
            variableId = BR.itemViewModel
        )
}

interface OnClickByUser {
    fun onClick()
}
