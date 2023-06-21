package com.example.a02_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a02_ex1.databinding.ActivityMainBinding
import kotlin.math.roundToInt
import kotlin.text.Typography.euro

class MainActivity : AppCompatActivity() {
    //Nota: exercício 1 e 2 - Converter Euros para Dólares
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDolar.setOnClickListener{
            val euro: Double = binding.editNumber.text.toString().toDouble()
            //2 formas de arredondamento:
            //val resultado: Double = (euro * 1.09188 * 100).roundToInt().toDouble() / 100
            val resultado: Double = String.format("%.2f", euro * 1.09188).toDouble()
            binding.textResultado.text = "Valor em dólares: ${resultado}$"
        }
    }


}