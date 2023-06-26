package com.example.a05_ex4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a05_ex4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNumber.setOnClickListener {
            val number: Int = binding.editNumber.text.toString().toInt()
            val resultado: Int = number % 2
            var Primo = true

            if(resultado == 0) {
                binding.textPar.text = "O número é par"
            }
            else {
                binding.textPar.text = "O número é ímpar"
            }
            if (number <= 1) {
                Primo = false
            } else {
                for (i in 2 until number) {
                    if (number % i == 0) {
                        Primo = false
                        break
                    }
                }
            }
            if (Primo) {
                binding.textPrimo.text = "O número é primo"
            } else {
                binding.textPrimo.text = "O número não é primo"
            }
        }
    }
}