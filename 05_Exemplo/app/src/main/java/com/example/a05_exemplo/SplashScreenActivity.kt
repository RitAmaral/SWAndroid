package com.example.a05_exemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler //se der erro, preciso de importar isto, ou carrego com o botao lado direto no handler
import android.os.Looper

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },3000) //depois de 3000 milissegundos / 3 seg vai para a Main activity
    }
}