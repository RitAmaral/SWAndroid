package com.example.a05_ex2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.widget.Toast
import com.example.a05_ex2.databinding.ActivityLoginErradoBinding
import com.example.a05_ex2.databinding.ActivityMainBinding

class LoginErradoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginErradoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginErradoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(applicationContext, "Login Errado", Toast.LENGTH_SHORT).show()

        binding.buttonVoltar.setOnClickListener {
            //startActivity(Intent(this, ActivityMainBinding::class.java))
            finish() //basta colocar finish para voltar
        }
    }
}