package com.example.a06_intent_retorno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_intent_retorno.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val nome = i.extras?.getString("nome") //isto traz o nome do main activity

        binding.editNome.setText(nome)

        binding.buttonOk.setOnClickListener {
            val novoNome = binding.editNome.text.toString()
            i.putExtra("nome", novoNome)
            setResult(1,i)
            //qnd eu clicar no botao ok, vou alterar o nome, e vou associar o código 1
            finish()
        }
        binding.buttonCancelar.setOnClickListener {
            setResult(2, i)
            finish()
        }
    }
}