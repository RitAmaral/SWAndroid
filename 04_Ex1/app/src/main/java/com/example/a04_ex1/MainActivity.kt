package com.example.a04_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a04_ex1.databinding.ActivityMainBinding

//04 - Exercício 1

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConverter.setOnClickListener{
            val euro: Double = binding.editValorEuros.text.toString().toDouble()
            //2 formas de arredondamento:
            //val resultado: Double = (euro * 1.09188 * 100).roundToInt().toDouble() / 100
            val resultado: Double = String.format("%.2f", euro * 1.09188).toDouble()
            binding.textValorDolares.text = "Valor em Dólares: ${resultado}$"
        }
    }
}