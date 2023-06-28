package com.example.a06_ex4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //06 Ex 4
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkBoxSalmao.setOnClickListener {
            binding.buttonPedido.setOnClickListener {
                val salmao = "Salmão"
                val i = Intent(this, SplashScreen::class.java)
                i.putExtra("salmao", salmao) //envia o nome para outro lado
                startActivity(i)
            }
        }
        binding.checkBoxVitela.setOnClickListener {
            binding.buttonPedido.setOnClickListener {
                val vitela = "Vitela"
                val i = Intent(this, SplashScreen::class.java)
                i.putExtra("vitela", vitela)
                startActivity(i)
            }
        }
        binding.checkBoxLimonada.setOnClickListener {
            binding.buttonPedido.setOnClickListener {
                val limonada = "Limonada"
                val i = Intent (this, SplashScreen::class.java)
                i.putExtra("limonada", limonada)
                startActivity(i)
            }
        }
        binding.checkBoxAgua.setOnClickListener {
            binding.buttonPedido.setOnClickListener {
                val agua = "Água"
                val i = Intent (this, SplashScreen::class.java)
                i.putExtra("agua", agua)
                startActivity(i)
            }
        }
        /*
        binding.buttonPedido.setOnClickListener {
            binding.checkBoxLimonada.setOnClickListener {
                val limonada = "Limonada"
                val i = Intent (this, SplashScreen::class.java)
                i.putExtra("limonada", limonada)
                startActivity(i)
            }
            binding.checkBoxAgua.setOnClickListener {
                val agua = "Água"
                val i = Intent (this, SplashScreen::class.java)
                i.putExtra("agua", agua)
                startActivity(i)
            }
            binding.checkBoxSalmao.setOnClickListener {
                val salmao = "Salmão"
                val i = Intent(this, SplashScreen::class.java)
                i.putExtra("salmao", salmao) //envia o nome para outro lado
                startActivity(i)
            }
            binding.checkBoxVitela.setOnClickListener {
                val vitela = "Vitela"
                val i = Intent(this, SplashScreen::class.java)
                i.putExtra("vitela", vitela)
                startActivity(i)
            }
        }
        */
    }
}