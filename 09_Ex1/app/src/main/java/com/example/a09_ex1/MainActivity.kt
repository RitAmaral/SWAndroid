package com.example.a09_ex1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a09_ex1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //faz a ligação ao documento ficheiro.xml onde estarão e serão guardados os valores
        val sharedPreferences = this.getSharedPreferences("ficheiro", Context.MODE_PRIVATE)

        //ler valor de USERNAME gravado no ficheiro, caso não exista fica vazio
        val userGravado = sharedPreferences.getString("USERNAME", "").toString()
        val passGravada = sharedPreferences.getString("PASSWORD", "").toString()

        //mostra o valor de userGravado e passGravada nos campos de editar
        binding.editUser.setText(userGravado)
        binding.editPass.setText(passGravada)

        binding.buttonAdd.setOnClickListener {
            val username = binding.editUser.text.toString()
            val password = binding.editPass.text.toString()

            Toast.makeText(applicationContext, "Login válido", Toast.LENGTH_SHORT).show()

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("USERNAME", username) //o que vai aparecer no ficheiro xml
            editor.putString("PASSWORD", password)
            editor.apply()
        }
    }
}