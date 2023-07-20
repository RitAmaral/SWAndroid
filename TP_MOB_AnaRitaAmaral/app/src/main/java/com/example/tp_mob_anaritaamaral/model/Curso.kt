package com.example.tp_mob_anaritaamaral.model


import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date


class Curso (var id: Int = 0, var nome: String = "", var local: String = "",
             var dataInicial: String = "", var dataFinal: String = "", var preco: String = "",
             var duracao: Int = 0, var edicao: String = "", var imagemID: Int = 0) {

    //var dataInicial: Date = Date() //${formatarData(dataInicial)}
    override fun toString(): String {
        return "$nome | $local - $dataInicial"
    }

    //Para a data aparecer como: 15-07-2023, em vez de Monday....
    @SuppressLint("SimpleDateFormat")
    private fun formatarData(data: Date): String {
        val formatoData = SimpleDateFormat("dd-MM-yyyy")
        return formatoData.format(data)
    }
}