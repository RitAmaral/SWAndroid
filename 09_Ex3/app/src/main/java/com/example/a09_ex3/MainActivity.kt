package com.example.a09_ex3

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a09_ex3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //carregar no botão para ouvir um cão
        binding.buttonCao.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.audiodog)
            mediaPlayer.start()
        }

        binding.buttonGato.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.audiocat)
            mediaPlayer.start()
        }

        binding.buttonPassaro.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.audiobird)
            mediaPlayer.start()
        }
    }
}