package com.example.tp_mob_anaritaamaral

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp_mob_anaritaamaral.adapter.CursoListAdapter
import com.example.tp_mob_anaritaamaral.adapter.UtilizadorListAdapter
import com.example.tp_mob_anaritaamaral.data.CursoMock
import com.example.tp_mob_anaritaamaral.data.UtilizadorMock
import com.example.tp_mob_anaritaamaral.databinding.ActivityAddCursoBinding
import com.example.tp_mob_anaritaamaral.model.Curso
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AddCursoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddCursoBinding
    private lateinit var listaCursos: ArrayList<Curso>

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

            val formatoData = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val dataInicial: Date? = formatoData.parse(inicio)
            val dataFinal: Date? = formatoData.parse(fim)

            if (dataInicial != null && dataFinal != null) {
                db.insertCurso(nome, local, dataInicial, dataFinal, preco, duracao, edicao)
                CarregarCurso(db)
                db.close()
            }
        }
        
    }
    private fun CarregarCurso(db: DBHelper) {
        listaCursos = db.selectAllCursosLista()
    }

}