package com.example.a07_ex3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.a07_ex3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var pos = -1

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

        //posso colocar this ou application context neste caso em baixo
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAluno)
        binding.listaviewAlunos.adapter = arrayAdapter //ligar listview à lista

        binding.listaviewAlunos.setOnItemClickListener { _, _, position, _ ->
            val i = Intent(this, DadosActivity::class.java)
            i.putExtra("nome", listaAluno[position].nome)
            i.putExtra("morada", listaAluno[position].morada)
            i.putExtra("email", listaAluno[position].email)
            startActivity(i)
        } //passar dados (nome morada e email) do item selecionado para a próxima activity

        binding.buttonAdicionar.setOnClickListener {
            val nome = binding.editNome.text.toString()
            val morada = binding.editMorada.text.toString()
            val email = binding.editEmail.text.toString()
            listaAluno.add(Aluno(nome, morada, email))
            arrayAdapter.notifyDataSetChanged() //notificar listview da alteração na lista
            binding.editNome.setText("") //passar os campos para vazios após adição
            binding.editMorada.setText("")
            binding.editEmail.setText("")
        }

        binding.listaviewAlunos.setOnItemLongClickListener { _, _, position, _ ->
            binding.editNome.setText(listaAluno[position].nome)
            binding.editMorada.setText(listaAluno[position].morada)
            binding.editEmail.setText(listaAluno[position].email)
            pos = position
            true
        } //qnd clicarmos longamente num item, os dados vão para os campos

        binding.buttonEditar.setOnClickListener {
            if (pos >= 0 && pos < listaAluno.size) {
                listaAluno[pos].nome = binding.editNome.text.toString()
                listaAluno[pos].morada = binding.editMorada.text.toString()
                listaAluno[pos].email = binding.editEmail.text.toString()
                pos = -1
                arrayAdapter.notifyDataSetChanged()
                binding.editNome.setText("") //passar os campos para vazios após edição
                binding.editMorada.setText("")
                binding.editEmail.setText("")
            }
        }
        binding.buttonRemover.setOnClickListener {
            if (pos >= 0 && pos < listaAluno.size) {
                listaAluno.removeAt(pos)
                pos = -1
                arrayAdapter.notifyDataSetChanged()
                binding.editNome.setText("") //passar os campos para vazios após eliminação
                binding.editMorada.setText("")
                binding.editEmail.setText("")
            }
        }
    }
}