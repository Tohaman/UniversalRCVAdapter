package com.example.universallistadapter.datasource

import com.example.universallistadapter.entitys.User

class Repository {
    fun loadFirstList(): List<User> {
        return firstList
    }

    fun loadSecondList(): List<User> {
        return secondList
    }
}

val firstList = listOf(
    User(
        1,
        "Pyotr",
        "Tchaikovsky",
        true
    ),
    User(2, "Richard", "Wagner", false),
    User(
        3,
        "Johannes",
        "Brahms",
        false
    ),
    User(4, "Franz", "Schubert", false),
    User(5, "Giuseppe", "Verdi", false)
)

val secondList = listOf(
    User(1, "Vasili", "Chapaev", false),
    User(2, "Rob", "Tomas", true),
    User(
        3,
        "Johannes",
        "Brahms",
        false
    ),
    User(4, "Franz", "Schubert", false),
    User(5, "Giuseppe", "Verdi", false),
    User(
        6,
        "Michael",
        "Shumakher",
        false
    ),
    User(7, "Ivan", "Urgant", true),
    User(8, "Anton", "Chekhov", false),
    User(9, "Dan", "Braun", false)
)