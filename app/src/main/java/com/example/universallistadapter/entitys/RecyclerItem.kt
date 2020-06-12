package com.example.universallistadapter.entitys

import androidx.annotation.LayoutRes

data class RecyclerItem(
    val data: Any,
    @LayoutRes val layoutId: Int,
    val variableId: Int
)