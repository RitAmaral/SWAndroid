package com.example.a04_ex4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a04_ex4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //04 - Exercício 4

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEntrar.setOnClickListener {
            val user = binding.editUser.text.toString()
            val pass = binding.editPass.text.toString()
            if (user == "user" && pass == "password") {
                Toast.makeText(applicationContext, "Login Válido", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(applicationContext, "Login Inválido", Toast.LENGTH_SHORT).show()
                val user = ""
                val pass = ""
            }

        }
    }
}