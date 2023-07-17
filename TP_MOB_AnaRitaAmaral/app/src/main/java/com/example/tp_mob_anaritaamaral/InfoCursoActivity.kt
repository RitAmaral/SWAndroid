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
    //private lateinit var listaCursos: ArrayList<Curso>
    private lateinit var curso: Curso
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ligação à base de dados
        val db = DBHelper(this)

        val i = intent //buscar o id que vem do CursosActivity

        curso = db.selectCursoByIDObjeto(i.getIntExtra("id", 0))


    }
}