package com.example.a14_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.a14_sqlite.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaUtilizadores: ArrayList<Utilizador>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //criar ligação à base de dados
        val db = DBHelper(this)
        listaUtilizadores = ArrayList() //inicializo a lista de utilizadores
        CarregarUtilizadores(db)

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            //puxa os dados do admin ou user para os campos editId, ....
            binding.editId.setText(listaUtilizadores[position].id.toString())
            binding.editUsername.setText(listaUtilizadores[position].username.toString())
            binding.editPassword.setText(listaUtilizadores[position].password.toString())
        }

        binding.buttonInsert.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()

            val res = db.insertUtilizador(username, password)
            Toast.makeText(this, res.toString(), Toast.LENGTH_SHORT).show()
            CarregarUtilizadores(db) //recarrega a base de dados
        }

        binding.buttonUpdate.setOnClickListener {
            val id = binding.editId.text.toString().toInt()
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()

            val res = db.updateUtilizador(id, username, password)
            Toast.makeText(this, res.toString(), Toast.LENGTH_SHORT).show()
            CarregarUtilizadores(db) //recarrega a base de dados
        }

        binding.buttonDelete.setOnClickListener {
            val id = binding.editId.text.toString().toInt()
            val res = db.deleteUtilizador(id)
            Toast.makeText(this, res.toString(), Toast.LENGTH_SHORT).show()
            //corri o programa, eliminei o user e o admin, e voltei a dar play eles não aparecem;
            // só desistalando a app do tablet e depois voltar a dar play
            CarregarUtilizadores(db) //recarrega a base de dados
        }
    }
    //método que permite ir à base de dados, buscar os utilizadores e mudá-los na listview
    private fun CarregarUtilizadores(db: DBHelper) {
        listaUtilizadores = db.selectAllUtilizadorLista()
        val adapter = ArrayAdapter(this, android.R.layout. simple_list_item_1, listaUtilizadores)
        binding.listView.adapter = adapter
    }
}