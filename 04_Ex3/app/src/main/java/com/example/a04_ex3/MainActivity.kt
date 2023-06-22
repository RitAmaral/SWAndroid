package com.example.a04_ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a04_ex3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //04 - Exercício 3

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDolar.setOnClickListener{
            val euro: Double = binding.editValorEuros.text.toString().toDouble()
            val resultado: Double = String.format("%.2f", euro * 1.20).toDouble()
            //binding.textValorDolares.text = "Valor em Dólares: ${resultado}$"
            Toast.makeText(applicationContext, "Valor em Doláres: ${resultado}\$", Toast.LENGTH_SHORT).show()
        }
        binding.buttonReal.setOnClickListener {
            val euro: Double = binding.editValorEuros.text.toString().toDouble()
            val resultado: Double = String.format("%.2f", euro * 4.4).toDouble()
            //binding.textValorDolares.text = "Valor em Reais: ${resultado}$"
            Toast.makeText(applicationContext, "Valor em Reais: R$ ${resultado}", Toast.LENGTH_SHORT).show()
        }
        binding.buttonPeso.setOnClickListener {
            val euro: Double = binding.editValorEuros.text.toString().toDouble()
            val resultado: Double = String.format("%.2f", euro * 31.5).toDouble()
            //binding.textValorDolares.text = "Valor em Pesos: ${resultado}$"
            Toast.makeText(applicationContext, "Valor em Pesos: ${resultado}\$", Toast.LENGTH_SHORT).show()
        }
    }
}