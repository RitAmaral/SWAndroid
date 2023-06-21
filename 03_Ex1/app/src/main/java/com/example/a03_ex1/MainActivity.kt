package com.example.a03_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a03_ex1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOla.setOnClickListener {
            val nome = binding.editNome.text.toString()
            val apelido = binding.editApelido.text.toString()

            if (nome.isEmpty()) {
                binding.textResultado.text = "Nome não inserido"
            }
            else if (apelido.isEmpty()) {
                binding.textResultado.text = "Apelido não inserido"
            }
            else {
                binding.textResultado.text = "Olá ${nome} ${apelido}!"
            }

        }


    }
}