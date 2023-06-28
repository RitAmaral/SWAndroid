package com.example.a06_ex4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a06_ex4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //06 Ex 4
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPedido.setOnClickListener {
            val qtnsal : Int = binding.editQtnsal.text.toString().toInt()
            val qtnvit : Int = binding.editQtnvit.text.toString().toInt()
            val qtnlim : Int = binding.editQtnlim.text.toString().toInt()
            val qtnagua : Int = binding.editQtnagua.text.toString().toInt()

            val i = Intent(this, SplashScreen::class.java)

            if (binding.checkBoxSalmao.isChecked)
                i.putExtra("qtnsal", qtnsal)
            if(binding.checkBoxVitela.isChecked)
                i.putExtra("qtnvit", qtnvit)
            if (binding.checkBoxLimonada.isChecked)
                i.putExtra("qtnlim", qtnlim)
            if (binding.checkBoxAgua.isChecked)
                i.putExtra("qtnagua", qtnagua)
            startActivity(i)
        }
    }
}