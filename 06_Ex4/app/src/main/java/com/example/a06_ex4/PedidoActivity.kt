package com.example.a06_ex4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex4.databinding.ActivityMainBinding
import com.example.a06_ex4.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent

        val salmao = i.extras?.getString("salmao")
        val vitela = i.extras?.getString("vitela")
        val limonada = i.extras?.getString("limonada")
        val agua = i.extras?.getString("agua")

        val precovit : Double = 10.00
        val precosal : Double = 11.00
        val precolim : Double = 2.50
        val precoagua : Double = 1.00

        if(salmao != null) {
            binding.textRes.setText("${salmao}, preço: ${precosal}€")
        }
        if(vitela != null) {
            binding.textRes.setText("${vitela}, preço: ${precovit}€")
        }
        if(limonada != null) {
            binding.textRes.setText("${limonada}, preço: ${precolim}€")
        }
        if(agua != null) {
            binding.textRes.setText("${agua}, preço: ${precoagua}€")
        }
        if(salmao != null && agua != null) {
            binding.textRes.setText("${salmao} e ${agua}")
        }
        if(salmao != null && limonada != null) {
            binding.textRes.setText("${salmao} e ${limonada}")
        }
        if(vitela != null && agua != null) {
            binding.textRes.setText("${vitela} e ${agua}")
        }
        if(vitela != null && limonada != null) {
            binding.textRes.setText("${vitela} e ${limonada}")
        }

    }
}