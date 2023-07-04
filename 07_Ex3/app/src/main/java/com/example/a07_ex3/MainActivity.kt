package com.example.a07_ex3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.a07_ex3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaAluno = ArrayList<Aluno>()
        listaAluno.add(Aluno("Rita", "Rua Joaquim", "rita@gmail.com"))
        listaAluno.add(Aluno("José", "Rua Janeiro", "jose@gmail.com"))
        listaAluno.add(Aluno("Maria", "Rua Trinta", "maria@gmail.com"))
        listaAluno.add(Aluno("Rui", "Rua Dezembro", "rui@gmail.com"))
        listaAluno.add(Aluno("António", "Rua Braga", "antonio@gmail.com"))

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAluno)
        binding.listaAlunos.adapter = arrayAdapter

        binding.listaAlunos.setOnItemClickListener { _, _, position, _ ->
            val i = Intent(this, DadosActivity::class.java)
            i.putExtra("nome", listaAluno[position].nome)
            i.putExtra("morada", listaAluno[position].morada)
            i.putExtra("email", listaAluno[position].email)
            startActivity(i)
        }
    }
}