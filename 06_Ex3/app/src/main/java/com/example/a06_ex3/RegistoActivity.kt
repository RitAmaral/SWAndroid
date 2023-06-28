package com.example.a06_ex3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex3.databinding.ActivityRegistoBinding

class RegistoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegisto.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            val user = binding.editUser.text.toString().trim() //pede user ao utilizador
            val pass = binding.editPass.text.toString().trim()
            i.putExtra("user", user) //leva user para a login activity
            i.putExtra("pass", pass)
            startActivity(i)
        }
    }
}