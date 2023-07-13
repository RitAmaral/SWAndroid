package com.example.tp_mob_anaritaamaral.model


import java.util.Date

class Curso (var id: Int = 0, var nome: String = "", var local: String = "",
             var dataInicial: Date? = null, var dataFinal: Date? = null, var preco: String = "",
             var duracao: Int = 0, var edicao: String = "") {

    override fun toString(): String {
        return "$nome | $local - $dataInicial"
    }
}