package com.example.a06_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex1.databinding.ActivityMainBinding
import com.example.a06_ex1.databinding.ActivitySegundaBinding

class MainActivity : AppCompatActivity() {
    //06 - Ex 01 - pedir dados, e mostra-los na segunda activity
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOk.setOnClickListener {
            val nome = binding.editNome.text.toString()
            val morada = binding.editMorada.text.toString()
            val telefone = binding.editNumber.text.toString()
            val email = binding.editEmail.text.toString()
            val genero = binding.editGenero.text.toString()

            val i = Intent(this, SegundaActivity::class.java)
            i.putExtra("nome", nome) //envia o nome para outro lado
            i.putExtra("morada", morada)
            i.putExtra("telefone", telefone)
            i.putExtra("email", email)
            i.putExtra("genero", genero)
            startActivity(i)
        }
    }
}