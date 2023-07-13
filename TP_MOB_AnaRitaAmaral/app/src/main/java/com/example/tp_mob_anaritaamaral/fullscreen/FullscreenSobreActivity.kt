package com.example.tp_mob_anaritaamaral.fullscreen

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import com.example.tp_mob_anaritaamaral.databinding.ActivityFullscreenSobreBinding

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class FullscreenSobreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullscreenSobreBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFullscreenSobreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Colocar em modo fullscreen
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { //if é para versões API 30 ou acima
            window.insetsController?.hide(WindowInsets.Type.statusBars()) //esconder a barra em cima com as horas etc
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            //o else é para versoes antigas, abaixo de 30
        }
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON) //manter sempre o ecrã ligado

    }
}