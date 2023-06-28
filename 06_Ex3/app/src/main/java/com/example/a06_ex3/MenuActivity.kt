package com.example.a06_ex3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex3.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegisto.setOnClickListener {
            startActivity(Intent(this, RegistoActivity::class.java))
        } //vai para registo activity

        binding.buttonLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        } //vai para login activity

        binding.buttonSobre.setOnClickListener {
            startActivity(Intent(this, SobreActivity::class.java))
        }//vai para sobre activity
    }
}