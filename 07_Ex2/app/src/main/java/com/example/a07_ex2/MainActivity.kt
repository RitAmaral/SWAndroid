package com.example.a07_ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.a07_ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaNumeros = ArrayList<Int>()
        listaNumeros.add(2)
        listaNumeros.add(5)
        listaNumeros.add(3)
        listaNumeros.add(6)
        listaNumeros.add(7)
        listaNumeros.add(1)

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNumeros)
        binding.listNumeros.adapter = arrayAdapter

        binding.buttonAdicionar.setOnClickListener {
            val numero = binding.editNumber.text.toString().toInt()
            listaNumeros.add(numero)
            arrayAdapter.notifyDataSetChanged()
            binding.editNumber.setText("")
        }
    }
}