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

        binding.editQtnsal.isEnabled = false
        binding.editQtnvit.isEnabled = false
        binding.editQtnlim.isEnabled = false
        binding.editQtnagua.isEnabled = false

        binding.checkBoxSalmao.setOnClickListener {
            if(binding.checkBoxSalmao.isChecked){
                binding.editQtnsal.isEnabled = true
                binding.editQtnsal.setText("1")
            } else {
                binding.editQtnsal.isEnabled = false
                binding.editQtnsal.setText("0")
            }
        }
        binding.checkBoxVitela.setOnClickListener {
            if(binding.checkBoxVitela.isChecked){
                binding.editQtnvit.isEnabled = true
                binding.editQtnvit.setText("1")
            } else {
                binding.editQtnvit.isEnabled = false
                binding.editQtnvit.setText("0")
            }
        }
        binding.checkBoxLimonada.setOnClickListener {
            if(binding.checkBoxLimonada.isChecked){
                binding.editQtnlim.isEnabled = true
                binding.editQtnlim.setText("1")
            } else {
                binding.editQtnlim.isEnabled = false
                binding.editQtnlim.setText("0")
            } //ou colocar a linha em baixo e comentar as linhas true e false.
            //binding.editQtnlim.isEnabled = binding.checkBoxLimonada.isChecked
        }
        binding.checkBoxAgua.setOnClickListener {
            if(binding.checkBoxAgua.isChecked){
                binding.editQtnagua.isEnabled = true
                binding.editQtnagua.value = 1
            } else {
                binding.editQtnagua.isEnabled = false
                binding.editQtnagua.value = 0
            }
        }
        binding.editQtnagua.minValue = 0 //number picker
        binding.editQtnagua.maxValue = 20

        binding.buttonPedido.setOnClickListener {
            val qtnsal : Int = binding.editQtnsal.text.toString().toInt()
            val qtnvit : Int = binding.editQtnvit.text.toString().toInt()
            val qtnlim : Int = binding.editQtnlim.text.toString().toInt()
            val qtnagua : Int = binding.editQtnagua.value.toString().toInt()

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
        /*
        ou, dentro do buttonPedido:
        val i = Intent(this, ...
        i.putExtra("qtnsal", binding.checkBoxSalmao.isChecked)
        i.putExtra("qtnvit", binding....
        */

    }
}