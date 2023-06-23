package com.example.a05_exemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a05_exemplo.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding //colocar Aqui ActivityLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater) //colocar aqui ActivityLogin
        setContentView(binding.root)

        /*
        binding.buttonVoltar.setOnClickListener {
            //nota, podemos fazer desta forma em baixo, ou da forma como está em MainActivity
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        } //colocar intent para voltar à main activity
        */

        //também posso fazer isto:
        binding.buttonVoltar.setOnClickListener {
            finish() 
        }
    }
}