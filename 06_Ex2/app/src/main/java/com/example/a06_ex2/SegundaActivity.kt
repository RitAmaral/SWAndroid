package com.example.a06_ex2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import com.example.a06_ex2.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySegundaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val bundle = i.extras

        binding.buttonOkay.setOnClickListener {
            val number2 = binding.editNum.text.toString().toInt()
            val i2 = Intent(this, TerceiraActivity::class.java)

            if (bundle != null) {
                i2.putExtras(bundle)
            }

            i2.putExtra("number2", number2)
            startActivity(i2)

        }

    }
}