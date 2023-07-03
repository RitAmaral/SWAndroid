package com.example.a06_ex3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a06_ex3.databinding.ActivityRegistoBinding

class RegistoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegisto.setOnClickListener {
            //val i = Intent(this, LoginActivity::class.java)
            val username = binding.editUser.text.toString().trim() //pede user ao utilizador
            val password = binding.editPass.text.toString().trim()
            val password1 = binding.editPass2.text.toString().trim()

            if(password != password1){
                Toast.makeText(applicationContext, "Passwords não correspondem", Toast.LENGTH_SHORT).show()
                binding.editUser.setText("")
                binding.editPass.setText("")
                binding.editPass2.setText("")
            } else{
                val i = intent
                i.putExtra("username", username) //leva user para a login activity
                i.putExtra("password", password)
                setResult(1,i)
                finish()
            }


        }
    }
}