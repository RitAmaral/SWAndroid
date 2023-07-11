package com.example.a14_sqlite

class Utilizador (var id: Int = 0, var username: String = "", var password: String = "") {

    override fun toString(): String {
        return username
    }
}