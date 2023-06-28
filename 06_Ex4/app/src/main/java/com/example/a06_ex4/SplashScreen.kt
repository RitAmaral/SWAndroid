package com.example.a06_ex4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val i = intent
        val bundle = i.extras

        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this, PedidoActivity::class.java)
            if (bundle != null) {
                i.putExtras(bundle)
            }
            startActivity(i)
            finish()
        }, 2000)


    }
}