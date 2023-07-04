package com.example.a07_listviewobjetos
//adicionar novo ficheiro, classe: new -> kotlin class/file

class Pessoa (var nome: String, var password: String){

    override fun toString(): String {
        return nome //"Pessoa (nome ='$nome', password ='$password')"
    }
}
//uma pessoa tem 2 parametros: username e password
//metodo tostring para mostrar a pessoa: clicar com o botao direito dentro das chavetas: generate toString()
//override é uma função que já existe, e nós estamos a rescreve-la, e quero apresentar desta forma: "Pessoa(nome='$nome', password='$password')"
//Posso por apenas return nome -> e mostra so o nome