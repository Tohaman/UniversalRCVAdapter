package com.example.universallistadapter.entitys

data class User(
    val id: Long,
    val firstName: String,
    val lastName: String,
    var isChecked: Boolean
)