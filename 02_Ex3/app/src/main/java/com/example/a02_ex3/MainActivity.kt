package com.example.a02_ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a02_ex3.databinding.ActivityMainBinding
import kotlin.math.roundToInt
import kotlin.text.Typography.euro

class MainActivity : AppCompatActivity() {

    //Nota: exercício 3 - Converter de Celsius para Fahrenheit

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonF.setOnClickListener {
            val celsius: Double = binding.editCelsius.text.toString().toDouble()
            val resultado: Double = celsius * 1.8 + 32
            binding.textResultado.text = "Temperatura em Fahrenheit: ${resultado}"
        }
    }
}