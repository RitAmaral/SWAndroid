package com.example.a13_recyclerview.data

import com.example.a13_recyclerview.model.Carro

class CarroMock {
    var listaCarros = ArrayList<Carro>()

    //construtor inicial: quando instanciar vai inicialiar a lista de carros
    init {
        listaCarros.add(Carro(1, "BMW"))
        listaCarros.add(Carro(2, "Mercedes"))
        listaCarros.add(Carro(3, "Aston Martin"))
        listaCarros.add(Carro(4, "McLaren"))
        for (i in 0 .. 100) {
            listaCarros.add(Carro(i, i.toString()))
        }
    }
}