package com.example.tp_mob_anaritaamaral.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp_mob_anaritaamaral.AddCursoActivity
import com.example.tp_mob_anaritaamaral.DBHelper
import com.example.tp_mob_anaritaamaral.InfoCursoActivity
import com.example.tp_mob_anaritaamaral.R
import com.example.tp_mob_anaritaamaral.adapter.CursoListAdapter
import com.example.tp_mob_anaritaamaral.data.CursoMock
import com.example.tp_mob_anaritaamaral.databinding.ActivityCursosBinding
import com.example.tp_mob_anaritaamaral.model.Curso

class CursosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCursosBinding
    private lateinit var listaCursos: ArrayList<Curso>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCursosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ligação à base de dados
        val db = DBHelper(this)
        listaCursos = ArrayList()

        //Definir adapter e layout:
        binding.reyclerViewCursos.layoutManager = LinearLayoutManager(this)

        val mock = CursoMock()
        /*
        binding.reyclerViewCursos.adapter =
            CursoListAdapter(mock.listaCursos, CursoListAdapter.OnClickListener { curso ->
                Toast.makeText(this, curso.nome, Toast.LENGTH_SHORT).show()
            })
         */

        binding.reyclerViewCursos.adapter =
            CursoListAdapter(mock.listaCursos, CursoListAdapter.OnClickListener { curso ->
                val cursoSelecionado = db.selectCursoByIDObjeto(curso.id)

                if (cursoSelecionado.nome.isEmpty()) {
                    Toast.makeText(this, "Curso ainda não criado", Toast.LENGTH_SHORT).show()
                } else {
                    //Ir para InfoCursoActivity com as info do curso selecionado
                    val i = Intent(this, InfoCursoActivity::class.java)
                    i.putExtra("id", cursoSelecionado.id)
                    i.putExtra("nome", cursoSelecionado.nome)
                    i.putExtra("local", cursoSelecionado.local)
                    i.putExtra("dataInicial", cursoSelecionado.dataInicial)
                    i.putExtra("dataFinal", cursoSelecionado.dataFinal)
                    i.putExtra("preco", cursoSelecionado.preco)
                    i.putExtra("duracao", cursoSelecionado.duracao)
                    i.putExtra("edicao", cursoSelecionado.edicao)
                    startActivity(i)
                    db.close()
                }
            })

        binding.buttonAdd.setOnClickListener {
            startActivity(Intent(this, AddCursoActivity::class.java))
        }
    }
    private fun CarregarCursos(db: DBHelper) {
        listaCursos = db.selectAllCursosLista()
    }

}