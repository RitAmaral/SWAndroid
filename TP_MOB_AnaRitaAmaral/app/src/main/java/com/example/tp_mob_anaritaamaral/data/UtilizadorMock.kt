package com.example.tp_mob_anaritaamaral.data

import com.example.tp_mob_anaritaamaral.model.Utilizador

class UtilizadorMock {

    var listaUtilizadores = ArrayList<Utilizador>()

    //construtor inicial: quando instanciar vai inicialiar a lista de carros
    init {

        for (i in 0 .. 50) {
            listaUtilizadores.add(Utilizador(i, i.toString()))
        }
    }
}