package com.example.a06_ex2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import com.example.a06_ex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //06 - Ex 2

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOk.setOnClickListener {
            val number = binding.editNumber.text.toString().toDouble()
            val i = Intent(this, SegundaActivity::class.java)
            i.putExtra("number", number)
            startActivity(i)
        }
    }
}