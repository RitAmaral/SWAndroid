package com.example.tp_mob_anaritaamaral.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp_mob_anaritaamaral.LoginActivity
import com.example.tp_mob_anaritaamaral.RegistarActivity
import com.example.tp_mob_anaritaamaral.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Ir para RegistarActivity
        binding.buttonRegistar.setOnClickListener {
            startActivity(Intent(this, RegistarActivity::class.java))
        }

        //Ir para LoginActivity
        binding.buttonLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}