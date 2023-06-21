package com.example.a02_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a02_ex1.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    //Nota: exercício 1 e 2
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDolar.setOnClickListener{
            var euro: Double = binding.editNumber.text.toString().toDouble()
            var resultado: Double = (euro * 1.09188 * 100).roundToInt().toDouble() / 100
            binding.textResultado.text = "Valor em dólares: ${resultado}$"
        }
    }


}