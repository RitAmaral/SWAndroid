package com.example.a06_ex3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a06_ex3.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val i = intent
            val usernameValido = i.extras?.getString("username") //vai buscar user ao registo activity
            val passwordValido = i.extras?.getString("password")

            val username = binding.editUsername.text.toString().trim() //pede username ao utilizador
            val password = binding.editPassword.text.toString().trim()

            if (username == usernameValido && password == passwordValido) { //se igual, vai para a sobre activity
                startActivity(Intent(this, SobreActivity::class.java))
                finish()
            } else {
                Toast.makeText(applicationContext, "Login errado", Toast.LENGTH_SHORT).show()
                binding.editUsername.setText("") //se errado, põe o campo username vazio
                binding.editPassword.setText("")
            }
        }

    }
}