package com.example.tp_mob_anaritaamaral

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp_mob_anaritaamaral.databinding.ActivityAddCursoBinding

class AddCursoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddCursoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}