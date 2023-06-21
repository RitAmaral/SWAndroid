package com.example.a03_ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a03_ex2.databinding.ActivityMainBinding

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
                Toast.makeText(applicationContext, "Nome não inserido", Toast.LENGTH_SHORT).show()
            }
            else if (apelido.isEmpty()) {
                Toast.makeText(applicationContext, "Apelido não inserido", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(applicationContext, "Olá ${nome} ${apelido}!", Toast.LENGTH_SHORT).show()
            }

        }


    }
}