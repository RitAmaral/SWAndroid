package com.example.a07_listviewobjetos

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.a07_listviewobjetos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var pos = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaPessoa = ArrayList<Pessoa>()
        listaPessoa.add(Pessoa("Rita", "pass123"))
        listaPessoa.add(Pessoa("Carlos", "password"))
        listaPessoa.add(Pessoa("Natália", "pass"))
        listaPessoa.add(Pessoa("Joana", "123"))
        listaPessoa.add(Pessoa("Fábio", "word"))

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPessoa)
        //este adaptador recebeu a listagem de pessoas, e agora vai alimentar a list view:
        binding.listViewNomes.adapter = arrayAdapter

        //clicar num item da lista:
        binding.listViewNomes.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(applicationContext, listaPessoa[position].password, Toast.LENGTH_SHORT).show() //vai apresentar a password associada à pessoa
            binding.editNome.setText(listaPessoa[position].nome) //sempre que clico num nome, aparece o nome no campo editNome
            binding.editPassword.setText(listaPessoa[position].password) //sempre que clico num nome, aparece a pass no campo editPassword
            pos = position //extrair e guardar a posição que for clicada
        }

        binding.listViewNomes.setOnItemLongClickListener { _, _, position, _ -> //se clicar durante muito tempo aparece a posição: 0, 1, ..
            Toast.makeText(applicationContext, position.toString(), Toast.LENGTH_SHORT).show()
            return@setOnItemLongClickListener true //ou colocar apenas: true
        }

        //Executar CRUD (create, read, update, delete) em cima de uma estrutura:

        binding.buttonAdicionar.setOnClickListener {
            val nome = binding.editNome.text.toString() //ler nome inserido pelo utilizador
            val pass = binding.editPassword.text.toString()
            listaPessoa.add(Pessoa(nome, pass))
            arrayAdapter.notifyDataSetChanged() //vai dizer que houve uma alteração à lista, e reatuliza-se
            //se refresh na app, estes elementos adicionados por aqui voltam a desaparecer
        }

        binding.buttonEditar.setOnClickListener {
            if (pos >= 0 && pos < listaPessoa.size) {
                listaPessoa[pos].nome = binding.editNome.text.toString()
                listaPessoa[pos].password = binding.editPassword.text.toString()
                pos = -1
                arrayAdapter.notifyDataSetChanged()
            } //edita um elemento
        }

        binding.buttonEliminar.setOnClickListener {
            if (pos >= 0 && pos < listaPessoa.size) {
                listaPessoa.removeAt(pos)
                pos = -1 //como -1 tá fora do intervalo lá em cima, resolve o problema, só volta a eliminar quando clicarmos numa posição válida
                arrayAdapter.notifyDataSetChanged()
            }
        }
    }
}