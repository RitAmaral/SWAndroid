package com.example.a05_ex4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a05_ex4.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNumber.setOnClickListener {
            val number: Int = binding.editNumber.text.toString().toInt()
            val resultado: Int = number % 2 //se ao dividir o number por 2 o res for 0, é par
            var Primo = true

            //verifica se é par ou ímpar
            if(resultado == 0) {
                binding.textPar.text = "O número é par"
            }
            else {
                binding.textPar.text = "O número é ímpar"
            }
            //verifica se é primo ou não
            if (number <= 1) { //número primo tem de ser maior que 1
                Primo = false
            } else {
                for (i in 2 until number) {
                    if (number % i == 0) { //número não é primo pq tem um divisor diferente de 1 e de ele mesmo.
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

            //outra forma de fazer, é fazer funções:
            //ParImpar(number)
            //Primo(number)
        }

    }
    /*
    fun ParImpar(number: Int) {
        if(number%2==0){
            binding.textPar.text = "Número par"
        } else {
            binding.textPar.text = "Número ímpar"
        }
    }
    fun Primo(number: Int) {
        if (number <= 1) {
            binding.textPrimo.text = "Número não é primo"
            return
        }
        for (i in 2..sqrt(number.toDouble()).toInt()) {
            if (number % i == 0) {
                binding.textPrimo.text = "Número não é primo"
                return
            }
        }
        binding.textPrimo.text = "Número é primo"
    }
    */
}