package com.example.tp_mob_anaritaamaral.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp_mob_anaritaamaral.data.DBHelper
import com.example.tp_mob_anaritaamaral.adapter.CursoListAdapter
import com.example.tp_mob_anaritaamaral.databinding.ActivityCursosBinding
import com.example.tp_mob_anaritaamaral.model.Curso

class CursosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCursosBinding
    private lateinit var listaCursos: ArrayList<Curso>
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var adapter: CursoListAdapter

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
    }

    private fun CarregarCursos(db: DBHelper) {
        listaCursos = db.selectAllCursosLista()

    }

}