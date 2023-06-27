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
            val username = binding.editUser.text.toString().trim()
            val pass = binding.editPass.text.toString().trim()

            if (username == "user" && pass == "pass"){
                val i = Intent(this, LoginOkActivity::class.java)
                i.putExtra("username", username)
                startActivity(i)
            //podemos colocar ambas as variáveis com o mesmo nome
            //porque ou é executado um bloco de código, ou é o outro
                //put extra, colocar também o username
            }
            else {
                val i = Intent(this, LoginErradoActivity::class.java)
                startActivity(i)
            }
        }
    }
}