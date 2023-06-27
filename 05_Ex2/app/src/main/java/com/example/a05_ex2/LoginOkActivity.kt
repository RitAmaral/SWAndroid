package com.example.a05_ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a05_ex2.databinding.ActivityLoginOkBinding

class LoginOkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginOkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginOkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent

        val username = i.extras?.getString("username")
        // ? = se tiver extras

        binding.textBemvindo.text = "Bem-vindo, ${username}!"
    }
}