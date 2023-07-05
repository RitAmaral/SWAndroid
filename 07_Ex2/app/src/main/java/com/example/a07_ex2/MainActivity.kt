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
        listaNumeros.add(2) //adicionar números à lista
        listaNumeros.add(5)
        listaNumeros.add(3)
        listaNumeros.add(6)
        listaNumeros.add(7)
        listaNumeros.add(1)

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNumeros)
        binding.listviewNumeros.adapter = arrayAdapter //ligar a list view à lista

        binding.listviewNumeros.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(applicationContext, listaNumeros[position].toString(), Toast.LENGTH_SHORT).show()
            binding.editNumber.setText(listaNumeros[position].toString()) //se tivermos a trabalhar com inteiros, colocar toString() aqui a na linha em cima
            pos = position
        } //se clicarmos num item da lista, aparece um toast com o número e esse número é colocado no campo  edit number

        binding.buttonAdicionar.setOnClickListener {
            val numero = binding.editNumber.text.toString()
            if (numero.isNotEmpty()) { //se o campo não tiver vazio..
                listaNumeros.add(numero.toInt()) //adiciona o número que colocamos no campo
                arrayAdapter.notifyDataSetChanged() //notifica que houve alteração na listview e coloca lá o número
                binding.editNumber.setText("") //para o campo de edit number voltar a ficar limpo
            } else {
                Toast.makeText(applicationContext, "Insira um valor antes de o adicionar", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonEditar.setOnClickListener {
            if (pos >= 0 && pos < listaNumeros.size) {
                listaNumeros[pos] = binding.editNumber.text.toString().toInt()
                pos = -1
                arrayAdapter.notifyDataSetChanged()
                binding.editNumber.setText("")
            }
        }
        binding.buttonRemover.setOnClickListener {
            if (pos >= 0 && pos < listaNumeros.size){
                listaNumeros.removeAt(pos)
                pos = -1
                arrayAdapter.notifyDataSetChanged()
                binding.editNumber.setText("")
            }
        }
    }
}