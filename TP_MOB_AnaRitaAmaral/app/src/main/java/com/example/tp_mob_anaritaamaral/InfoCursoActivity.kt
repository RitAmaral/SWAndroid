package com.example.tp_mob_anaritaamaral

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp_mob_anaritaamaral.databinding.ActivityInfoCursoBinding
import com.example.tp_mob_anaritaamaral.model.Curso
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class InfoCursoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoCursoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent

        val nome = i.extras?.getString("nome")
        val local = i.extras?.getString("local")
        val dataInicial1 = i.extras?.getString("dataInicial")
        val dataFinal1 = i.extras?.getString("dataFinal")
        val preco = i.extras?.getString("preco")
        val duracao = i.extras?.getInt("duracao")
        val edicao = i.extras?.getString("edicao")

        val formatoData = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val dataInicial: Date = formatoData.parse(dataInicial1)
        val dataFinal: Date = formatoData.parse(dataFinal1)

        binding.textRes.setText("Nome do Curso: $nome \nLocal: $local \nData Inicial: $dataInicial" +
                "\nData Final: $dataFinal \nPreço: $preco€ \nDuração: $duracao horas \nEdição: $edicao")
    }
}