package com.example.a09_audio

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1º em cima do res, adicionar (new) um directory: raw
        //2º colocar o ficheiro audio na pasta, depois escrever:
        val mediaPlayer = MediaPlayer.create(this, R.raw.audio)
        mediaPlayer.start()
        
    }
}