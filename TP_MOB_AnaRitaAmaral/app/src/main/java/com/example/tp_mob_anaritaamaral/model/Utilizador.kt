package com.example.tp_mob_anaritaamaral.model

class Utilizador (var id: Int = 0, var username: String = "", var password: String = "") {

    override fun toString(): String {
        return "Nome de Utilizador: $username"
    }
}