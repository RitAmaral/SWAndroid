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

        val sharedPreferences = this.getSharedPreferences("ficheiro", Context.MODE_PRIVATE)
        val notaGravada = sharedPreferences.getString("NOTA", "").toString()

        binding.textRes.setText(notaGravada)

        binding.buttonGravar.setOnClickListener {
            val nota = binding.editNota.text.toString()

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("NOTA", nota)
            editor.apply()
        }
    }
}