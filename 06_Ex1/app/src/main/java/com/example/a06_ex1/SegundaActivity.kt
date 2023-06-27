package com.example.a06_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex1.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySegundaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val nome = i.extras?.getString("nome") //isto traz o nome do main activity
        val morada = i.extras?.getString("morada")
        val telefone = i.extras?.getString("telefone")
        var email = i.extras?.getString("email")
        var genero = i.extras?.getString("genero")

        binding.textRes.text = "A ${nome}, do genero ${genero}, mora na rua ${morada}, tem o telefone ${telefone} e o email ${email}"
    }
}