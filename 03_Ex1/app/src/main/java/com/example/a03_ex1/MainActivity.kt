package com.example.a03_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a03_ex1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //03 - Exercício 1

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOla.setOnClickListener {
            val nome = binding.editNome.text.toString().trim() //trim limpa os espaços em branco antes e depois
            val apelido = binding.editApelido.text.toString().trim()

            if (nome.isEmpty()) {
                binding.textResultado.text = "Nome não inserido"
            }
            else if (apelido.isEmpty()) {
                binding.textResultado.text = "Apelido não inserido"
            }
            else {
                binding.textResultado.text = "Olá ${nome} ${apelido}!"
            }
            //ou
            //if (nome.isEmpty() || apelido.isEmpty())
            //ou também podemos usar: if (nome.isNullOrBlank()


        }


    }
}