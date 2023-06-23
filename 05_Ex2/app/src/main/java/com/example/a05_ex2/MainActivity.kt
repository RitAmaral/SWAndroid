package com.example.a05_ex2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a05_ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEntrar.setOnClickListener {
            val user = binding.editUser.text.toString().trim()
            val pass = binding.editPass.text.toString().trim()

            if (user == "user" && pass == "pass"){
                startActivity(Intent(this, LoginOkActivity::class.java))
            }
            else {
                startActivity(Intent(this, LoginErradoActivity::class.java))
            }
        }
    }
}