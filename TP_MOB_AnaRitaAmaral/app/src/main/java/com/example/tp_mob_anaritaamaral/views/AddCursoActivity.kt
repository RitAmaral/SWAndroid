package com.example.tp_mob_anaritaamaral.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tp_mob_anaritaamaral.R
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

        //ler os valores e registar curso
        binding.buttonAdicionar.setOnClickListener {
            val nome = binding.editNome.text.toString()
            val local = binding.editLocal.text.toString()
            val inicio = binding.editInicio.text.toString()
            val fim = binding.editFim.text.toString()
            val preco = binding.editPreco.text.toString()
            val duracao = binding.editDuracao.text.toString().toInt()
            val edicao = binding.editEdicao.text.toString()
            val imagemID = binding.editImagemid.text.toString().toInt()

            //val formatoData = SimpleDateFormat("dd-MM-yyyy")
            //val dataInicial: Date? = formatoData.parse(inicio)
            //val dataFinal: Date? = formatoData.parse(fim)

            if (nome.isNotEmpty() && local.isNotEmpty() && inicio.isNotEmpty() && fim.isNotEmpty()
                && preco.isNotEmpty() && duracao != null && edicao.isNotEmpty() && imagemID != null)
            {
                val res = db.insertCurso(
                    nome,
                    local,
                    inicio,
                    fim,
                    preco,
                    duracao.toInt(),
                    edicao,
                    imagemID.toInt()
                )

                if (res > 0) {
                    Toast.makeText(applicationContext, getString(R.string.curso_adicionado), Toast.LENGTH_SHORT)
                        .show()
                    setResult(1, intent)
                    finish()
                    //db.close()
                } else {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.erro_curso_nao_adicionado),
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }
    }
}
