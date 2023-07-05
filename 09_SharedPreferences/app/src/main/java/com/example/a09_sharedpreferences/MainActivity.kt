package com.example.a09_sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a09_sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //faz a ligação ao documento ficheiro.xml onde estarão e serão guardados os valores
        val sharedPreferences = this.getSharedPreferences("ficheiro", Context.MODE_PRIVATE)

        //ler valor de NOME gravado no ficheiro, caso não exista fica vazio
        val nomeGravado = sharedPreferences.getString("NOME", "").toString()
        //mostra o valor de NOME no layout
        binding.textNome.text = nomeGravado

        binding.buttonGravar.setOnClickListener {
            val nome = binding.editNome.text.toString()
            binding.textNome.text = nome

            val pass = binding.editPass.text.toString()
            binding.textNome.text = nome + "\n" + pass

            //gravação do valor inserido e guardado em nome, etiquetado como NOME, nas SharedPreferences - no documendo: ficheiro
            val editor: SharedPreferences.Editor = sharedPreferences.edit() //isto é um tipo de dados
            editor.putString("NOME", nome)
            editor.putString("SENHA", pass)
            editor.apply()
            //ir a device file explorer ------>
            //data -> data -> com.example.a09_sharedpreferences
            //executar app, escrever nome, voltar ao com.example, sincronizar, shared_prefs -> ficheiro.xml
        }
    }
}