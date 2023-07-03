package com.example.a06_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex1.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySegundaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val nome = i.extras?.getString("nome") //isto traz o nome do main activity
        val morada = i.extras?.getString("morada")
        val telefone = i.extras?.getString("telefone")
        val email = i.extras?.getString("email")
        //var genero = i.extras?.getString("genero")
        val genero = i.extras?.getString("genero")?.lowercase() //passa para letra minuscula, mas com o radio button, já não é preciso

        if(genero == "f" /* || genero == "feminino" */){
            binding.textRes.text = "A ${nome}, do genero ${genero}, mora na rua ${morada}, tem o telefone ${telefone} e o email ${email}"
        } else {
            binding.textRes.text = "O ${nome}, do genero ${genero}, mora na rua ${morada}, tem o telefone ${telefone} e o email ${email}"
        }

    }
}