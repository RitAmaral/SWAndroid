package com.example.tp_mob_anaritaamaral

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp_mob_anaritaamaral.adapter.CursoListAdapter
import com.example.tp_mob_anaritaamaral.data.CursoMock
import com.example.tp_mob_anaritaamaral.databinding.ActivityInfoCursoBinding
import com.example.tp_mob_anaritaamaral.model.Curso
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class InfoCursoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoCursoBinding
    private lateinit var listaCursos: ArrayList<Curso>
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //ligação à base de dados
        val db = DBHelper(this)
        listaCursos = ArrayList()

        //Definir adapter e layout:
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val mock = CursoMock()

        binding.recyclerView.adapter =
            CursoListAdapter(mock.listaCursos, CursoListAdapter.OnClickListener { curso ->
                 db.selectCursoByIDObjeto(curso.id)

            /*    //não acho que faça sentido colocar intent.. visto que os dados estão guardados na base de dados
            val i = intent

            val id = i.extras?.getInt("id")
            val nome = i.extras?.getString("nome")
            val local = i.extras?.getString("local")
            val dataInicial1 = i.extras?.getString("dataInicial")
            val dataFinal1 = i.extras?.getString("dataFinal")
            val preco = i.extras?.getString("preco")
            val duracao = i.extras?.getInt("duracao")
            val edicao = i.extras?.getString("edicao")

            val formatoData = SimpleDateFormat("dd-MM-yyyy")
            val dataInicial: Date = formatoData.parse(dataInicial1)
            val dataFinal: Date = formatoData.parse(dataFinal1)

            binding.textRes.text = "Nome do Curso: $nome \nLocal: $local \nData Inicial: $dataInicial" +
                "\nData Final: $dataFinal \nPreço: $preco€ \nDuração: $duracao horas \nEdição: $edicao"
            */
    })
}}