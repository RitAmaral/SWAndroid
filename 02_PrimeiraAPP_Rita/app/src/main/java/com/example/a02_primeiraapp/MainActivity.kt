package com.example.a02_primeiraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a02_primeiraapp.databinding.ActivityMainBinding

//No ficheiro MainActivity.kt vamos implementar o ViewBinding (liga XML a KT):

class MainActivity : AppCompatActivity() {
    //criação da variável binding que é do tipo ActivityMainBinding:
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Instanciação, fazer sempre isto em todos os projetos:
        binding = ActivityMainBinding.inflate(layoutInflater) //liga layout à programação; isto vai buscar tudo o que está no activity main (button, etc)
        //setContentView(R.layout.activity_main) //isto vai ser substituído por:
        setContentView(binding.root) //Agora já temos ligação entre os 2 lados (xml e kt)

        binding.buttonOla.setOnClickListener {
            binding.editNome.setText("Olá") //ao clicar no botão aparece escrito: Olá
        }
        //posso fazer cliques em todos os elementos, não precisa de ser um botão:
        binding.textResultado.setOnClickListener {
            binding.editNome.setText("Adeus") //ao clicar no TextView, aparece escrito: Adeus
        }

    }
}