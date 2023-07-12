package com.example.tp_mob_anaritaamaral

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tp_mob_anaritaamaral.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var resultado: ActivityResultLauncher<Intent>
    var username = "" //colocar aqui para conseguir aceder no login e no resultado
    var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Ir para RegistarActivity
        binding.buttonRegistar.setOnClickListener {
            //val i = Intent(this, RegistarActivity::class.java)
            //resultado.launch(i)
            startActivity(Intent(this, RegistarActivity::class.java))
        }

        //Ir para LoginActivity
        binding.buttonLogin.setOnClickListener {
            //val i = Intent(this, LoginActivity::class.java)
            //i.putExtra("username", username)
            //i.putExtra("password", password)
            //startActivity(i)
            startActivity(Intent(this, LoginActivity::class.java))
        }

        //Verificar que os dados estão certos:
        /*
        resultado = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.data != null && it.resultCode == 1){ //código inserido em registar activity = 1
                username = it.data?.extras?.getString("username").toString()
                password = it.data?.extras?.getString("password").toString()
                Toast.makeText(applicationContext, "Dados de registo atualizados", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Erro ao atualizar dados de registo", Toast.LENGTH_SHORT).show()
            }
        }
        */

    }
}