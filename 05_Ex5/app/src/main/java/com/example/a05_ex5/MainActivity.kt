package com.example.a05_ex5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os
import com.example.a05_ex5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHoras.setOnClickListener {
            val horas: Int = binding.editHoras.text.toString().toInt()
            val semanas: Int = horas / 168 //1 semana tem 168 horas
            val dias: Int = (horas % 168) / 24
            val horasRestantes: Int = horas % 24

            binding.textSemana.text = "${horas} horas são ${semanas} semanas."
            binding.textDias.text = "${horas} horas são ${dias} dias."
            binding.textHoras.text = "${horas} horas são ${horasRestantes} horas."
        }
    }
}