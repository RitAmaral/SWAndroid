package com.example.a04_ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a04_ex3.databinding.ActivityMainBinding
import kotlin.text.Typography.euro

class MainActivity : AppCompatActivity() {
    //04 - Exercício 3

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDolar.setOnClickListener {
            Converter(1.2, "Dolar")
            //val euro: Double = binding.editValorEuros.text.toString().toDouble()
            //val resultado: Double = String.format("%.2f", euro * 1.2).toDouble()
            //binding.textValorDolares.text = "Valor em Dólares: ${resultado}$"
            //Toast.makeText(applicationContext, "Valor em Dolares: ${resultado}\$", Toast.LENGTH_SHORT).show()
        } //já não preciso de escrever isto tudo, porque está no método Converter
        binding.buttonReal.setOnClickListener {
            Converter(4.4, "Real")
            //val euro: Double = binding.editValorEuros.text.toString().toDouble()
            //val resultado: Double = String.format("%.2f", euro * 4.4).toDouble()
            //Toast.makeText(applicationContext, "Valor em Reais: R$ ${resultado}", Toast.LENGTH_SHORT).show()
        }
        binding.buttonPeso.setOnClickListener {
            Converter(31.5, "Peso")
            //val euro: Double = binding.editValorEuros.text.toString().toDouble()
            //val resultado: Double = String.format("%.2f", euro * 31.5).toDouble()
            //Toast.makeText(applicationContext, "Valor em Pesos: ${resultado}\$", Toast.LENGTH_SHORT).show()
        }
    }

    fun Converter(taxa: Double, euro: String) {
        val euro = binding.editValorEuros.text.toString()
        if (euro.isNotEmpty()) {
            try {
                val resultado: Double = String.format("%.2f", euro.toDouble() * taxa).toDouble()
                Toast.makeText(
                    applicationContext,
                    "Valor em Doláres: ${resultado}\$",
                    Toast.LENGTH_SHORT
                ).show()
            } catch (e: Exception) {
                Toast.makeText(applicationContext, "Valor inserido é inválido", Toast.LENGTH_SHORT)
                    .show()
            } //este try catch é redondante, porque já coloquei input type no editText
        } else {
            Toast.makeText(
                applicationContext,
                "Insira um valor em euros antes de converter",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}