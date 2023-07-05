package com.example.a07_ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a07_ex3.databinding.ActivityDadosBinding

class DadosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDadosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDadosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val nome = i.extras?.getString("nome") //extras é um potencial nulo, por isso devemos colocar ?
        val morada = i.extras?.getString("morada")
        val email = i.extras?.getString("email")

        binding.textRes.text = "Nome: ${nome} \nMorada: ${morada} \nEmail: ${email}"
    }
}