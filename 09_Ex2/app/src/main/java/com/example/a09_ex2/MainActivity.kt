package com.example.a09_ex2

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a09_ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sp = this.getSharedPreferences("ficheiro", Context.MODE_PRIVATE)
        val notaGravada = sp.getString("NOTA", "").toString()

        binding.textRes.setText(notaGravada)

        binding.buttonGravar.setOnClickListener {
            val nota = binding.editNota.text.toString()
            binding.textRes.text = nota

            val editor: SharedPreferences.Editor = sp.edit()
            editor.putString("NOTA", nota)
            editor.apply()
        }
        //ao clicar na nota, ela aparece no campo edit nota
        binding.textRes.setOnClickListener {
            binding.editNota.setText(binding.textRes.text.toString())
        }
    }
}