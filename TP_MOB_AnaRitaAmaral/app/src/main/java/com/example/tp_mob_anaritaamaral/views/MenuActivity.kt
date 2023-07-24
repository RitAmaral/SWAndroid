package com.example.tp_mob_anaritaamaral.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp_mob_anaritaamaral.databinding.ActivityMenuBinding
import com.example.tp_mob_anaritaamaral.fullscreen.FullscreenSobreActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Ir para Cursos activity
        binding.buttonCursos.setOnClickListener {
            startActivity(Intent(this, CursosActivity::class.java))
        }

        //Ir para Sobre activity
        binding.buttonSobre.setOnClickListener {
            startActivity(Intent(this, FullscreenSobreActivity::class.java))
        }

    }
}