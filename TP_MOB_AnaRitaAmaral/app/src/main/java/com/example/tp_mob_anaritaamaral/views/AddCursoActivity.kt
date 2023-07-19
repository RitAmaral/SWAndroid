package com.example.tp_mob_anaritaamaral.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tp_mob_anaritaamaral.data.DBHelper
import com.example.tp_mob_anaritaamaral.databinding.ActivityAddCursoBinding
import java.text.SimpleDateFormat
import java.util.Date

class AddCursoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddCursoBinding

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DBHelper(this)

        binding.buttonAdicionar.setOnClickListener {
            val nome = binding.editNome.text.toString()
            val local = binding.editLocal.text.toString()
            val inicio = binding.editInicio.text.toString()
            val fim = binding.editFim.text.toString()
            val preco = binding.editPreco.text.toString()
            val duracao = binding.editDuracao.text.toString().toInt()
            val edicao = binding.editEdicao.text.toString()

            val formatoData = SimpleDateFormat("dd-MM-yyyy")
            val dataInicial: Date? = formatoData.parse(inicio)
            val dataFinal: Date? = formatoData.parse(fim)

            if (nome.isNotEmpty() && local.isNotEmpty() && dataInicial != null && dataFinal != null
                && preco.isNotEmpty() && duracao != null && edicao.isNotEmpty()
            ) {
                val res = db.insertCurso(
                    nome,
                    local,
                    dataInicial,
                    dataFinal,
                    preco,
                    duracao.toInt(),
                    edicao
                )

                if (res > 0) {
                    Toast.makeText(applicationContext, "Curso Adicionado", Toast.LENGTH_SHORT)
                        .show()
                    setResult(1, intent)
                    finish()
                    //db.close()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Erro: Curso não adicionado",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }
    }
}
