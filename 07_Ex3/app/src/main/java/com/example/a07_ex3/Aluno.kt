package com.example.a07_ex3

class Aluno (var nome: String, var morada: String, var email: String) { //nome classe sempre com a 1ª letra maiscula
    override fun toString(): String {
        return nome
    }
}