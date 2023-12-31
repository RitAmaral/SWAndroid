package com.example.a06_ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex2.databinding.ActivityTerceiraBinding

class TerceiraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTerceiraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerceiraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val i2 = intent

        val number = i.extras?.getDouble("number")
        val number2 = i2.extras?.getDouble("number2") //isto traz o number da segunda activity

        val soma = number!! + number2!! // !! garante que não são nulos, se tiver nulos, arrebenta com a app, por isso podemos usar como aparece em baixo:
        val dif = number!! - number2!! //para não arrebentar: number2?.let {number?.minus(it)}
        val prod = number!! * number2!!
        val div = number!! / number2!!

        binding.textSoma.setText("${number} + ${number2} = ${soma}")
        binding.textDiferenca.setText("${number} - ${number2} = ${dif}")
        binding.textProduto.setText("${number} * ${number2} = ${prod}")
        binding.textDivisao.setText("${number} / ${number2} = ${div}")
    }
}