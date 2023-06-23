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
            val user = binding.editUser.text.toString().trim()
            val pass = binding.editPass.text.toString().trim()

            if (user.isEmpty()){
                Toast.makeText(applicationContext, "Preencha o username antes de entrar", Toast.LENGTH_SHORT).show()
            }
            else if (pass.isEmpty()) {
                Toast.makeText(applicationContext, "Preencha a password antes de entrar", Toast.LENGTH_LONG).show()
            }
            else {
                if (user == "user" && pass == "pass") {
                    Toast.makeText(applicationContext, "Bem-vindo, ${user}!", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(applicationContext, "Login Inválido", Toast.LENGTH_LONG).show()
                    binding.editUser.text = null
                    binding.editPass.text = null
                    //ou colocar: binding.editUser.setText("")
                }
            }


        }
    }
}