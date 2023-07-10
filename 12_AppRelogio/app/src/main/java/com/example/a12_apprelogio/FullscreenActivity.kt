package com.example.a12_apprelogio

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
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
import android.widget.Toast
import com.example.a12_apprelogio.databinding.ActivityFullscreenBinding


class FullscreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullscreenBinding
    private var isChecked = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFullscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Colocar em modo fullscreen
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { //if é para versões API 30 ou acima
            window.insetsController?.hide(WindowInsets.Type.statusBars()) //esconder a barra em cima com as horas etc
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            //o else é para versoes antigas, abaixo de 30
        }
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON) //manter sempre o ecrã ligado

        //Mostrar nível de bateria
        val bateriaReceiver: BroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (intent != null) {
                    val nivel = intent. getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
                    //Toast.makeText(applicationContext, nivel.toString(), Toast.LENGTH_SHORT).show()
                    binding.texNivelBateria.text = nivel.toString() + "%"
                }
            }
        }
        registerReceiver(bateriaReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED)) //quero registar um receiver que vai estar à escuta

        binding.checkNivelBateria.setOnClickListener {
            if(isChecked){
                //isChecked = false
                //binding.checkNivelBateria.isChecked = false
                binding.texNivelBateria.visibility = View.GONE
            } else {
                //isChecked = true
                //binding.checkNivelBateria.isChecked = true
                binding.texNivelBateria.visibility = View.VISIBLE
            }
            isChecked = !isChecked
            binding.checkNivelBateria.isChecked = isChecked
        }
        /* //também podia fazer desta forma:
        if(binding.checkNivelBateria.isChecked) {
            binding.texNivelBateria.visibility = View.VISIBLE
        } else {
            binding.texNivelBateria.visibility = View.GONE
        }
        */

        //animate = animações simples
        binding.layoutMenu.animate().translationY(500F)

        //vamos mostrar o layout qnd carregamos na ferramenta (preferencias), e vamos esconder quando clicamos no X (fechar)
        binding.imageViewPreferencias.setOnClickListener {
            binding.layoutMenu.animate().translationY(0F).duration =
                resources.getInteger(android.R.integer.config_mediumAnimTime).toLong()
        }//0F: posição original

        binding.imageViewFechar.setOnClickListener {
            binding.layoutMenu.animate().translationY(binding.layoutMenu.measuredHeight.toFloat()).duration =
                resources.getInteger(android.R.integer.config_mediumAnimTime).toLong()
        }
    }
}