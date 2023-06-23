package com.example.a05_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a05_ex1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonClica.setOnClickListener {
            Toast.makeText(applicationContext, "Botão clicado", Toast.LENGTH_SHORT).show()
        }

        binding.buttonSecond.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}