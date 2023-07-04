package com.example.a07_ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.a07_ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var pos = -1

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

        binding.listNumeros.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(applicationContext, listaNumeros[position].toString(), Toast.LENGTH_SHORT).show()
            binding.editNumber.setText(listaNumeros[position].toString()) //se tivermos a trabalhar com inteiros, colocar toString() aqui a na linha em cima
            pos = position
        }

        binding.buttonAdicionar.setOnClickListener {
            val numero = binding.editNumber.text.toString().toInt()
            listaNumeros.add(numero)
            arrayAdapter.notifyDataSetChanged()
            binding.editNumber.setText("")
        }

        binding.buttonEditar.setOnClickListener {
            if (pos >= 0 && pos < listaNumeros.size) {
                listaNumeros[pos] = binding.editNumber.text.toString().toInt()
                pos = -1
                arrayAdapter.notifyDataSetChanged()
            }
        }
        binding.buttonRemover.setOnClickListener {
            if (pos >= 0 && pos < listaNumeros.size){
                listaNumeros.removeAt(pos)
                pos = -1
                arrayAdapter.notifyDataSetChanged()
            }
        }
    }
}