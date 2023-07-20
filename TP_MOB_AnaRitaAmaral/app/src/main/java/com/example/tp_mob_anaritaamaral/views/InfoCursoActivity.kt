package com.example.tp_mob_anaritaamaral.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tp_mob_anaritaamaral.data.DBHelper
import com.example.tp_mob_anaritaamaral.databinding.ActivityInfoCursoBinding
import com.example.tp_mob_anaritaamaral.model.Curso

class InfoCursoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoCursoBinding
    private lateinit var curso: Curso

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ligação à base de dados
        val db = DBHelper(this)
        val i = intent

        curso = db.selectCursoByIDObjeto(i.getIntExtra("id", 0))

        binding.botaoEditar.setOnClickListener {
            val imagemID = binding.textImagem.text.toString().toInt()
            val nome = binding.textNome.text.toString()
            val local = binding.textLocal.text.toString()
            val inicio = binding.textInicio.text.toString()
            val fim = binding.textFim.text.toString()
            val preco = binding.textPreco.text.toString()
            val duracao = binding.textDuracao.text.toString().toInt()
            val edicao = binding.textEdicao.text.toString()

            if (nome.isNotEmpty() && local.isNotEmpty() && inicio.isNotEmpty() && fim.isNotEmpty()
                && preco.isNotEmpty() && duracao != null && edicao.isNotEmpty() && imagemID != null) {
                val res = db.insertCurso(nome, local, inicio, fim, preco, duracao, edicao, imagemID)
                if (res>0) {
                    Toast.makeText(applicationContext, "Curso editado com sucesso", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Curso não editado", Toast.LENGTH_SHORT).show()
                }
            }
        }



        //Definir adapter e layout:
        //binding.recyclerView.layoutManager = LinearLayoutManager(this)

        //val mock = CursoMock()

        /*binding.recyclerView.adapter =
            CursoListAdapter(mock.listaCursos, CursoListAdapter.OnClickListener { curso ->
                 db.selectCursoByIDObjeto(curso.id)
*/
        /*
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
        //})
    }
}