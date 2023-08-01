package com.example.tp_mob_anaritaamaral.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp_mob_anaritaamaral.R
import com.example.tp_mob_anaritaamaral.data.DBHelper
import com.example.tp_mob_anaritaamaral.adapter.CursoListAdapter
import com.example.tp_mob_anaritaamaral.databinding.ActivityCursosBinding
import com.example.tp_mob_anaritaamaral.model.Curso

class CursosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCursosBinding
    private lateinit var listaCursos: ArrayList<Curso>
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var adapter: CursoListAdapter
    private var ordemCrescente = true //ordenar lista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCursosBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //ligação à base de dados
        val db = DBHelper(this)
        CarregarCursos(db)

        //Definir adapter e layout:
        binding.reyclerViewCursos.layoutManager = LinearLayoutManager(this)

        adapter = CursoListAdapter(listaCursos, CursoListAdapter.OnClickListener { curso ->
            val i = Intent(this, InfoCursoActivity::class.java)
            i.putExtra("id", curso.id)
            startActivity(i)
        })
        binding.reyclerViewCursos.adapter = adapter

        //adicionar curso:
        binding.buttonAdd.setOnClickListener {
            val i = Intent(this, AddCursoActivity::class.java)
            launcher.launch(i)
        }

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.data != null && it.resultCode == 1) {
                CarregarCursos(db)
                adapter = CursoListAdapter(listaCursos, CursoListAdapter.OnClickListener { curso ->
                    val i = Intent(this, InfoCursoActivity::class.java)
                    i.putExtra("id", curso.id)
                    startActivity(i)
                })
                binding.reyclerViewCursos.adapter = adapter
            }
        }

        //ordernar recycler view por ASC e DESC
        val ordernarLista = findViewById<RadioGroup>(R.id.radioGroupSort)
        ordernarLista.setOnCheckedChangeListener { _, checkedId ->
            ordemCrescente = checkedId == R.id.radio_crescente
            updateCursosList()
        }

        //voltar para trás
        binding.buttonVoltar.setOnClickListener {
            finish()
        }

    }

    private fun CarregarCursos(db: DBHelper) {
        listaCursos = db.selectAllCursosLista()

    }

    //ordenar lista por ASC e DESC
    private fun updateCursosList() {
        if (ordemCrescente) {
            listaCursos.sortBy { it.nome }
        } else {
            listaCursos.sortByDescending { it.nome }
        }
        adapter.notifyDataSetChanged()
    }

}