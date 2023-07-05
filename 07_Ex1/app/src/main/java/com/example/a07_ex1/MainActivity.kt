package com.example.a07_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.a07_ex1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaNomes = ArrayList<String>()
        listaNomes.add("Rita")
        listaNomes.add("Maria")
        listaNomes.add("José")
        listaNomes.add("Rui")
        listaNomes.add("António")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNomes)
        binding.listviewNomes.adapter = arrayAdapter

        binding.listviewNomes.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(applicationContext, "Olá ${listaNomes[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}