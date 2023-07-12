package com.example.a16_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.a16_room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userDatabase: UserDAO
    private lateinit var listaUtilizadores : List <UserModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userDatabase = UserDatabase.getDatabase(applicationContext).userDAO()

        LoadData()

        binding.buttonInsert.setOnClickListener {
            //vou criar uma variavel userModel que é um objeto de UserModel
            val userModel = UserModel().apply {
                username = binding.editUsername.text.toString()
                password = binding.editPassword.text.toString()
            }

            val res = userDatabase.insert(userModel)
            Toast.makeText(applicationContext, res.toString(), Toast.LENGTH_SHORT).show()
            LoadData() //recarregar os dados na base de dados
        }

        binding.buttonUpdate.setOnClickListener {
            val userModel = UserModel().apply {
                id = binding.textId.text.toString().toInt()
                username = binding.editUsername.text.toString()
                password = binding.editPassword.text.toString()
            }

            val res = userDatabase.update(userModel)
            Toast.makeText(applicationContext, res.toString(), Toast.LENGTH_SHORT).show()
            LoadData() //recarregar os dados na base de dados
        }

        binding.buttonDelete.setOnClickListener {
            val id = binding.textId.text.toString().toInt()
            val userModel = UserModel().apply {
                this.id = id
            }
            val res = userDatabase.delete(userModel)
            Toast.makeText(applicationContext, res.toString(), Toast.LENGTH_SHORT).show() //se aparecer 1, foi eliminado um user. se aparecer 0, ninguém foi eliminado
            LoadData()
        }

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            binding.textId.text = listaUtilizadores[position].id.toString()
            binding.editUsername.setText(listaUtilizadores[position].username)
            binding.editPassword.setText(listaUtilizadores[position].password)
        }
    }

    private fun LoadData() {
        listaUtilizadores = userDatabase.getAll()
        val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, listaUtilizadores)
        binding.listView.adapter = adapter

    }
}